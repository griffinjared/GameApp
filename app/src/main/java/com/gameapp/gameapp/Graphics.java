package com.gameapp.gameapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import levels.Level;
import levels.Level_1_Forest;
import levels.Level_2_Caves;
import levels.Level_3_Underwater;
import mob.players.Knight;
import mob.players.Player;

import static android.graphics.Color.*;

/** The Screen class used to be called "gameClass"
 *  Instead, it is now the graphics portion of the Game and only the graphics portion
 *  Since it extends SurfaceView, the Screen is nothing but a layer of graphics that is put over the Game Class
 *  Once the Screen is generated by the Game class, the MainThread is generated by the Screen class's constructor
 *  The onDraw method is where all graphics are rendered
 *  The update method is where all the game's numbers are updated every frame
 *  onDraw and update are both repeatedly called by the the MainThread every frame
 */

public class Graphics extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = Graphics.class.getSimpleName();

    public enum Direction {
        UP, LEFT, RIGHT, DOWN, STOP
    }

    public enum Combat {
        NONE, MAGIC, PHYSICAL
    }
    private Combat combat = Combat.NONE;

    enum GameState {
        Running, Equip, Item, Over
    }
    GameState state = GameState.Running;

    public enum CombatDirection {
        NORTH, EAST, SOUTH, WEST,
        NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST,
        NONE
    }
    CombatDirection combatDirection = CombatDirection.NONE;

    //Primary Components
    private MainThread thread;
    private SeedGenerator seeder;
    private Level level; //one instant of the level can be used for all levels
    private Player player; //the only playable and controllable character on-screen
    private Paint paint; //for drawing graphics
    private Bitmap joy_center, joy_up, joy_down, joy_left, joy_right;
    private Bitmap joystick;
    private Bitmap attackGrid;
    private boolean isHolding;
    private boolean isSwiping;
    private Direction direction;
    private int speed;

    public static final int SIZE = 288; //Dimensions of one regular room
    public static int maxSpeed = 7; //number of loop iterations between player moves, larger values slow player

    public Graphics(Game context) {
        super(context);
        getHolder().addCallback(this);

        //create the game loop thread
        thread = new MainThread(getHolder(), this);

        //Game components
        seeder = new SeedGenerator();
        player = new Knight(3, 5, getContext());
        level = new Level_1_Forest(getContext(), player, BitmapFactory.decodeResource(getResources(), R.drawable.tiles_level1_forest));
        maxSpeed = player.getBaseSpeed();
        paint = new Paint();
        isHolding = false;
        isSwiping = false;
        speed = 0;
        direction = Direction.STOP;
        combat = Combat.NONE;

        setFocusable(true);

        setBackgroundColor(Color.LTGRAY);

        player.setLevelPosition(level.getRoomX(), level.getRoomY());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        int joy = getWidth() * 4 / 9;

        //Joystick images
        joy_center = BitmapFactory.decodeResource(getResources(), R.drawable.joystick);
        joy_center = Bitmap.createScaledBitmap(joy_center, joy, joy, true);
        joy_up = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_up);
        joy_up = Bitmap.createScaledBitmap(joy_up, joy, joy, true);
        joy_down = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_down);
        joy_down = Bitmap.createScaledBitmap(joy_down, joy, joy, true);
        joy_left = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_left);
        joy_left = Bitmap.createScaledBitmap(joy_left, joy, joy, true);
        joy_right = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_right);
        joy_right = Bitmap.createScaledBitmap(joy_right, joy, joy, true);

        //attackGrid = BitmapFactory.decodeResource(getResources(), R.drawable.attackgrid);
        //attackGrid = Bitmap.createScaledBitmap(attackGrid, joy, joy, true);

        joystick = joy_center;
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

    //PLAYER CONTROLS
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int w = getWidth();
        int h = getHeight();
        int size = (h - w - (w/15));

        if(event.getAction() == MotionEvent.ACTION_DOWN) {

            isHolding = false;

            //State Change
            if (inBounds(event, 0, 0, 50, 50)) {
                pauseEquip();
                return true;
            }
            else if (inBounds(event, w-(w/40), 0, w - 50, 50)) {
                pauseItem();
                return true;
            }

            isHolding = true;

            //Combat
            if (inBounds(event, (2*w/40) + (12*w/27), h - size, 12*w/27, 12*w/27)) {
                combat(event);
                return true;
            }

            //Tap movement
            changeDirection(event);
        }

        //Drag movement
        else if(event.getAction() == MotionEvent.ACTION_MOVE) {
            changeDirection(event);
        }

        else if(event.getAction() == MotionEvent.ACTION_UP) {
            isHolding = false;
            joystick = joy_center;
            isSwiping = false;
            combat = Combat.NONE;
            combatDirection = CombatDirection.NONE;
            speed = 0;
        }
        return true;
    }

    //Combat events
    public void combat(MotionEvent event) {
        int w = getWidth();
        int h = getHeight();
        int size = (h - w - (w/15));

        isSwiping = true;
        isHolding = false;

        //NorthWest corner
        if(inBounds(event, (2*w/40) + (12*w/27), h - size, 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.NORTHWEST;
        }
        //North corner
        else if(inBounds(event, (2*w/40) + (16*w/27), h - size, 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.NORTH;
        }
        //NorthEast corner
        else if(inBounds(event, (2*w/40) + (20*w/27), h - size, 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.NORTHEAST;
        }
        //West corner
        else if (inBounds(event, (2*w/40) + (12*w/27), h - size + (4*w/27), 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.WEST;
        }
        //East corner
        else if (inBounds(event, (2*w/40) + (20*w/27), h - size + (4*w/27), 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.EAST;
        }
        //SouthWest corner
        else if (inBounds(event, (2*w/40) + (12*w/27), h - size + (8*w/27), 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.SOUTHWEST;
        }
        //South corner
        else if (inBounds(event, (2*w/40) + (16*w/27), h - size + (8*w/28), 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.SOUTH;
        }
        //SouthEast corner
        else if (inBounds(event, (2*w/40) + (20*w/27), h - size + (8*w/27), 4*w/27, 4*w/27)) {
            combatDirection = CombatDirection.SOUTHEAST;
        }
        Log.i(TAG, "Combat Start: " + combatDirection);
    }

    public void changeDirection(MotionEvent event) {
        int w = getWidth();
        int h = getHeight();
        int size = (h - w - (w/15));

        //Up
        if (inBounds(event, (w/40) + (4*w/27), h-size, 4*w/27, 4*w/27)) {
            joystick = joy_up;
            direction = Direction.UP;
        }
        //Down
        else if (inBounds(event, (w/40) + (4*w/27), h-size+(8*w/27), 4*w/27, 4*w/27)) {
            joystick = joy_down;
            direction = Direction.DOWN;
        }
        //Left
        else if (inBounds(event, w / 40, h - size + (4 * w / 27), 4 * w / 27, 4 * w / 27)) {
            joystick = joy_left;
            direction = Direction.LEFT;
        }
        //Right
        else if (inBounds(event, (w / 40) + (8 * w / 27), h - size + (4 * w / 27), 4 * w / 27, 4 * w / 27)) {
            joystick = joy_right;
            direction = Direction.RIGHT;
        }
    }


    public boolean getHolding() { return isHolding; }

    public Direction getDirection() { return direction; }

    public void update() {
        switch (state) {
            case Running: gameUpdate(); break;
            case Equip: break;
            case Item: break;
            case Over: break;
        }
    }

    public void gameUpdate() {
        if (isHolding) {
            if (speed == 0) {
                if (direction == Direction.UP) {
                    player.setY(-1, level.getCurrentRoom());
                    if(player.goingToNextLevel(0, -1, level.getCurrentRoom())) {
                        level = nextLevel();
                    }
                } else if (direction == Direction.DOWN) {
                    player.setY(1, level.getCurrentRoom());
                    if(player.goingToNextLevel(0, 1, level.getCurrentRoom())) {
                        level = nextLevel();
                    }
                } else if (direction == Direction.LEFT) {
                    player.setX(-1, level.getCurrentRoom());
                    if(player.goingToNextLevel(-1, 0, level.getCurrentRoom())) {
                        level = nextLevel();
                    }
                } else if (direction == Direction.RIGHT) {
                    player.setX(1, level.getCurrentRoom());
                    if(player.goingToNextLevel(1, 0, level.getCurrentRoom())) {
                        level = nextLevel();
                    }
                }
            }
            speed++;
            speed = speed % maxSpeed;
        }

        level.update(player.update());
    }

    private boolean inBounds(MotionEvent event, int x, int y, int width, int height) {
        return (event.getX() > x && event.getX() < x + width - 1 && event.getY() > y && event.getY() < y + height - 1);
    }

    @Override
    public void onDraw(Canvas canvas) {

        switch (state) {
            case Running: drawMainUI(canvas); break;
            case Equip: drawPausedUI(canvas); break;
            case Item: drawPausedUI(canvas); break;
            case Over: drawGameOverUI(canvas); break;
        }
    }

    private void drawPausedUI(Canvas canvas)
    {
        int w = getWidth();
        int h = getHeight();

        paint.setColor(WHITE);
        paint.setTextSize(30);
        canvas.drawRect(0, 0, w, h, paint);

        paint.setColor(BLACK);
        canvas.drawText("Resume", 5, h/3, paint);
    }
    private void drawGameOverUI(Canvas canvas)
    {
        int w = getWidth();
        int h = getHeight();

        paint.setColor(BLACK);
        paint.setTextSize(30);
        canvas.drawRect(0, 0, w, h, paint);

        paint.setColor(WHITE);
        canvas.drawText("Game Over", 5, h / 3 - (paint.getTextSize() * 2), paint);
        canvas.drawText("Main Menu", 5, h/3, paint);
    }
    private void drawMainUI(Canvas canvas) {
        /** What happens right here is the scaling process so that the game is always scaled adequately to the screen size
         *  The standard size of a room is 288 pixels (12 tiles * 24 pixels each)
         *  The canvas is scaled up the proper amount so that the length of the room is equal to the width of the screen
         */
        int size = (getHeight() - getWidth() - (getWidth()/15));

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
        paint.setColor(WHITE);
        paint.setFakeBoldText(true);
        canvas.drawText("Item", 5, w / 18, paint);
        canvas.drawText("Equip", w - (paint.getTextSize() * 6), w / 18, paint);

        paint.setColor(BLACK);
        canvas.drawText("HP: " + player.getHP() + "/" + player.getMaxHP(), 5, w + paint.getTextSize(), paint); //HP
        canvas.drawText("MP: " + player.getMP() + "/" + player.getMaxMP(), w - (5 * paint.getTextSize()), w + paint.getTextSize(), paint); //MP

        canvas.drawBitmap(joystick, w / 40, h - size, paint); //joystick

        //canvas.drawRect((w / 20) + (w * 4 / 9), h - size, w - (w / 40), h - size + (w * 4 / 9), paint); //Attack pad
        //canvas.drawBitmap(attackGrid, (w / 20) + (w * 4 / 9), h - size, paint);

        /*
        paint.setColor(RED);
        float[] linePts = {
        (w/20) + (w * 4/9) + (w * 4/27), h - size, (w/20) + (w * 4/9) + (w * 4/27), h - size + (w * 4/9),
        (w/20) + (w * 4/9) + (w * 8/27), h - size, (w/20) + (w * 4/9) + (w * 8/27), h - size + (w * 4/9),
        (w/20) + (w * 4/9), h - size + (w * 4/27), (w/20) + (w * 4/9) + (w * 4/9), h - size + (w * 4/27),
        (w/20) + (w * 4/9), h - size + (w * 8/27), (w/20) + (w * 4/9) + (w * 4/9), h - size + (w * 8/27)
        };
        // canvas.drawLine((w/20) + (w * 4/9) + (w * 4/27), h - size, (w/20) + (w * 4/9) + (w * 4/27), h - size + (w * 4/9), paint);
        // canvas.drawLine((w/20) + (w * 4/9) + (w * 8/27), h - size, (w/20) + (w * 4/9) + (w * 8/27), h - size + (w * 4/9), paint);
        canvas.drawLine(linePts[0], linePts[1], linePts[2], linePts[3], paint);
        canvas.drawLine(linePts[4], linePts[5], linePts[6], linePts[7], paint);
        canvas.drawLine(linePts[8], linePts[9], linePts[10], linePts[11], paint);
        canvas.drawLine(linePts[12], linePts[13], linePts[14], linePts[15], paint);
        */
    }

    public void pauseEquip()
    {
        if(state == GameState.Running)
        {
            state = GameState.Equip;
        }
        else resume();
    }
    public void pauseItem() {
        if (state == GameState.Running) {
            state = GameState.Item;
        }
        else resume();
    }

    public void resume()
    {
        state = GameState.Running;
    }
    private void goToMenu()
    {
        //TODO reverts back to main menu
    }
    private void resetGame()
    {
        //TODO sets all statistics to initial values
    }

    public Level nextLevel() {
        if (level.getLevelName().equals("Forest")) {
            return new Level_2_Caves(getContext(), player, BitmapFactory.decodeResource(getResources(), R.drawable.tiles_level2_caves));
        } else if (level.getLevelName().equals("Caves")) {
            return new Level_3_Underwater(getContext(), player, BitmapFactory.decodeResource(getResources(), R.drawable.tiles_level3_underwater));
        } else {
            return new Level(getContext());
        }
    }
}
