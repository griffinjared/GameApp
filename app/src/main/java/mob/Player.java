package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/** The real purpose of the Player class is to provide a sprite and controls
 */
public class Player extends Mob {

    public int direction = 7;

    /** 1 2 3
     *  4   5
     *  6 7 8
     */

    private int roomX, roomY; //coordinates in the level layout grid

    public Player(int x, int y, Bitmap sprites) {
        this.x = x*SIZE;
        this.y = y*SIZE;
        this.spriteSheet = Bitmap.createScaledBitmap(sprites, 192, 72, true);

        //Set all sprites
        down = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        down1 = Bitmap.createBitmap(spriteSheet, 0, SIZE, SIZE, SIZE);
        down2 = Bitmap.createBitmap(spriteSheet, 0, 2*SIZE, SIZE, SIZE);

        up = Bitmap.createBitmap(spriteSheet, 1, 0, SIZE, SIZE);
        up1 = Bitmap.createBitmap(spriteSheet, 1, SIZE, SIZE, SIZE);
        up2 = Bitmap.createBitmap(spriteSheet, 1, 2*SIZE, SIZE, SIZE);

        left = Bitmap.createBitmap(spriteSheet, 2, 0, SIZE, SIZE);
        left1 = Bitmap.createBitmap(spriteSheet, 2, SIZE, SIZE, SIZE);
        left2 = Bitmap.createBitmap(spriteSheet, 2, 2*SIZE, SIZE, SIZE);

        right = Bitmap.createBitmap(spriteSheet, 3, 0, SIZE, SIZE);
        right1 = Bitmap.createBitmap(spriteSheet, 3, SIZE, SIZE, SIZE);
        right2 = Bitmap.createBitmap(spriteSheet, 3, 2*SIZE, SIZE, SIZE);

        sprite = left;
    }

    public int update() {
        animate();

        if (x <= -SIZE) { //West
            x = (SIZE*12) - SIZE/2;
            return 4;
        }
        else if (x >= SIZE*12) { //East
            x = SIZE/2;
            return 2;
        }
        else if (y <= -SIZE) { //North
            y = (SIZE*12) - SIZE/2;
            return 1;
        }
        else if (y >= SIZE*12) { //East
            y = SIZE/2;
            return 3;
        }

        return 0;
    }

    public int getRoomX() {
        return roomX;
    }

    public int getRoomy() {
        return roomY;
    }

    //STAT METHODS
    public int getHP() {
        return hp;
    }

    public void setHP(int num) {
        hp += num;
        if (hp > maxHP) hp = maxHP;
        if (hp < 0) hp = 0;
    }

    public void setLevelPosition(int x, int y) {
        roomX = x;
        roomY = y;
    }

    public void draw(Canvas c, Paint p) {
        if (y > 288-24) return;
        super.draw(c, p);
    }

    public void animate() {
        anim++;
        int animation = 25;
        int stage1 = animation/4, stage2 = animation/2, stage3 = animation * 3 / 4, stage4 = animation;
        if (anim > animation) anim = 0;

        switch(direction) {
            //Left
            case 1:case 4:case 6:
                if (anim < stage1) sprite = left1;
                else if (anim < stage2) sprite = left;
                else if (anim < stage3) sprite = left2;
                else if (anim < stage4) sprite = left;
                break;
            //Up
            case 2:
                if (anim < stage1) sprite = up1;
                else if (anim < stage2) sprite = up;
                else if (anim < stage3) sprite = up2;
                else if (anim < stage4) sprite = up;
                break;
            //Right
            case 3:case 5:case 8:
                if (anim < stage1) sprite = right1;
                else if (anim < stage2) sprite = right;
                else if (anim < stage3) sprite = right2;
                else if (anim < stage4) sprite = right;
                break;
            case 7:
                if (anim < stage1) sprite = down1;
                else if (anim < stage2) sprite = down;
                else if (anim < stage3) sprite = down2;
                else if (anim < stage4) sprite = down;
                break;
        }
    }

}
