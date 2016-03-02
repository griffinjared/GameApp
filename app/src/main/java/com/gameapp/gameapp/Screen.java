package com.gameapp.gameapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.List;

import gameapp.framework.Input.TouchEvent;
import levels.Level;
import levels.Level_1_Forest;
import mob.Player;

/** The Screen class used to be called "gameClass"
 *  Instead, it is now the graphics portion of the Game and only the graphics portion
 *  Since it extends SurfaceView, the Screen is nothing but a layer of graphics that is put over the Game Class
 *  Once the Screen is generated by the Game class, the MainThread is generated by the Screen class's constructor
 *  The onDraw method is where all graphics are rendered
 *  The update method is where all the game's numbers are updated every frame
 *  onDraw and update are both repeatedly called by the the MainThread every frame
 */

public class Screen extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = Screen.class.getSimpleName();

    //Primary Components
    private MainThread thread;
    private SeedGenerator seeder;
    private Level level; //one instant of the level can be used for all levels
    private Player player; //the only playable and controllable character on-screen
    private Paint paint; //for drawing graphics
    private Bitmap joystick;
    private ControlPad controlPad;

    public static final int SIZE = 288; //Dimensions of one regular room

    enum GameState{
        Ready, Running, Paused, GameOver
    }
    GameState state = GameState.Ready;

    public Screen(Context context) {
        super(context);
        getHolder().addCallback(this);

        //create the game loop thread
        thread = new MainThread(getHolder(), this);

        //Game components
        seeder = new SeedGenerator();
        level = new Level_1_Forest(getContext(), BitmapFactory.decodeResource(getResources(), R.drawable.tiles_level1_forest));
        player = new Player(5, 5, BitmapFactory.decodeResource(getResources(), R.drawable.player_sprites_basic)); //Spawns center
        paint = new Paint();
        joystick = BitmapFactory.decodeResource(getResources(), R.drawable.joystick);
        controlPad = new ControlPad(getWidth()/40, getHeight()-(getHeight() - getWidth() - (getWidth()/24)) - (getWidth() / 40));

        setFocusable(true);

        setBackgroundColor(Color.LTGRAY);

        player.setLevelPosition(level.getRoomX(), level.getRoomY());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                //try again shutting down the thread
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if(event.getY() > getHeight() - 50) {
                thread.setRunning(false);
                ((Activity)getContext()).finish();
            } else {
                Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
            }
        }
        return super.onTouchEvent(event);
    }

    public void update() {
        player.setX(2);
        level.update(player.update());

        //TODO
        //List touchEvents = Game.getInput().getTouchEvents();
        //if(state == GameState.Paused)
            //updatePaused(touchEvents);
    }

    private void updatePaused(List touchEvents){
        int len = touchEvents.size();
        for(int i = 0; i < len; i++){
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP){
                if(inBounds(event, 0, 0, 800, 240)){
                    if(!inBounds(event, 0, 0, 35, 35)){
                        // resume(); this allows player to resume the game

                    }
                }
                if(inBounds(event, 0, 240, 800, 240)){
                    // nullify(); resets all of the character and variable information
                    // goToMenu(); takes the player back to the main menu
                }
            }
        }

    }

    public void updateRunning(List touchEvents, float deltaTime) {
        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) { // user touched screen
                // TODO: implement touch events
            }

            if (event.type == TouchEvent.TOUCH_UP) { // user stopped touching screen
                // TODO: implement touch stopped events
            }

            // TOUCH_DRAGGED and TOUCH_HOLD are also included
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        //this checks if the touchEvent passed occurred within the specified pixel bounds
        return (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1);
    }

    @Override
    /** The Paint class can probably used for any on-screen text.
     *  It cannot however, draw complex graphics and is limited to text and simple shapes like circles and rectangles
     */
    protected void onDraw(Canvas canvas) {
        /** What happens right here is the scaling process so that the game is always scaled adequately to the screen size
         *  The standard size of a room is 288 pixels (12 tiles * 24 pixels each)
         *  The canvas is scaled up the proper amount so that the length of the room is equal to the width of the screen
         */
        int size = (getHeight() - getWidth() - (getWidth()/24)) - (getWidth() / 40);
        joystick = Bitmap.createScaledBitmap(joystick, size, size, true);

        int w = getWidth();
        int h = getHeight();

        //Adjust scale to screen size
        float scaleFactor = ((w * 1.00f) / (SIZE * 1.00f)); //Portrait

        int saveState = canvas.save();
        canvas.scale(scaleFactor, scaleFactor);

        //Level - a lot of other things are contained and drawn in this class
        level.draw(canvas, paint);

        //Player, Mobs, and Enemies
        player.draw(canvas, paint);

        canvas.restoreToCount(saveState);
        //HUD, UI, and On-Screen Text
        paint.setTextSize(w / 24);

        //Button text
        paint.setColor(Color.WHITE);
        paint.setFakeBoldText(true);
        canvas.drawText("Menu", 5, w / 18, paint);
        canvas.drawText("Equipment", w - (paint.getTextSize() * 6), w / 18, paint);
        canvas.drawText("Map", 5, w - 5, paint);
        canvas.drawText("Inventory", w - (paint.getTextSize() * 5), w - 5, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("HP: 9999", 5, w + paint.getTextSize(), paint); //HP
        canvas.drawText("MP: 999", w - (5 * paint.getTextSize()), w + paint.getTextSize(), paint); //MP

        canvas.drawBitmap(joystick, w/40, h-size, paint); //joystick

        canvas.drawRect((w * 3 / 5) + w / 40, h - size, w - (w / 40), h - w / 40, paint); //Attack pad
    }
}
