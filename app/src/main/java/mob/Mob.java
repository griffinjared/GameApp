package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import rooms.Room;
import tiles.Tile;

/** The Mob class can be anything that moves around in the map, not just enemies.
 *  As such, the Player is a Mob as well.
 */
public class Mob {

    protected final int SIZE = Tile.SIZE;
    public static int x, y;
    protected int direction = 7;
    protected Bitmap spriteSheet; //Image where all the sprites are stored
    protected Bitmap sprite; //Primary, currently-active sprite
    protected int anim; //animation cycles

    //Sprites
    protected static Bitmap down, down1, down2;
    protected static Bitmap up, up1, up2;
    protected static Bitmap left, left1, left2;
    protected static Bitmap right, right1, right2;

    //Statistics
    protected int maxHP, maxMP, baseSpeed;
    protected int hp, mp, level, speed;

    public Mob(int x, int y, Bitmap sprites) {
        this.x = x*SIZE;
        this.y = y*SIZE;
        this.spriteSheet = Bitmap.createScaledBitmap(sprites, 192, 72, true);

        //Set all sprites
        down = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        //down1 = Bitmap.createBitmap(spriteSheet, 0, SIZE, SIZE, SIZE);
        //down2 = Bitmap.createBitmap(spriteSheet, 0, 2*SIZE, SIZE, SIZE);

        up = Bitmap.createBitmap(spriteSheet, SIZE, 0, SIZE, SIZE);
        //up1 = Bitmap.createBitmap(spriteSheet, SIZE, SIZE, SIZE, SIZE);
        //up2 = Bitmap.createBitmap(spriteSheet, SIZE, 2*SIZE, SIZE, SIZE);

        left = Bitmap.createBitmap(spriteSheet, 2*SIZE, 0, SIZE, SIZE);
        //left1 = Bitmap.createBitmap(spriteSheet, 2*SIZE, SIZE, SIZE, SIZE);
        //left2 = Bitmap.createBitmap(spriteSheet, 2*SIZE, 2*SIZE, SIZE, SIZE);

        right = Bitmap.createBitmap(spriteSheet, 3*SIZE, 0, SIZE, SIZE);
        //right1 = Bitmap.createBitmap(spriteSheet, 3*SIZE, SIZE, SIZE, SIZE);
        //right2 = Bitmap.createBitmap(spriteSheet, 3*SIZE, 2*SIZE, SIZE, SIZE);

        sprite = down;
        level = 1;
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int num, Room room) {
        if (num == 1) {
            if (!collision(num, 0, room)) x += (num*SIZE);
            sprite = right;
        }
        else {
            if (!collision(num, 0, room)) x += (num*SIZE);
            sprite = left;
        }
    }
    public void setY(int num, Room room) {
        if (num == 1) {
            if (!collision(0, num, room)) y += (num*SIZE);
            sprite = down;
        }
        else {
            if (!collision(0, num, room)) y += (num*SIZE);
            sprite = up;
        }
    }

    public boolean collision(int xa, int ya, Room room) {
        try {
            if (room.getTileLayout()[(y/24)+ya][(x/24)+xa] == 0) return true;
            else if (room.getTileLayout()[(y/24)+ya][(x/24)+xa] > 4) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }

    public void draw(Canvas c, Paint p) {

        c.drawBitmap(sprite, x, y, p);
    }

    public void animate() {
        //anim++;
        //int animation = 25;
        //int stage1 = animation/4, stage2 = animation/2, stage3 = animation * 3 / 4, stage4 = animation;
        //if (anim > animation) anim = 0;

        switch(direction) {
            //Left
            case 1:case 4:case 6: sprite = left;
                /*
                if (anim < stage1) sprite = left1;
                else if (anim < stage2) sprite = left;
                else if (anim < stage3) sprite = left2;
                else if (anim < stage4) sprite = left;
                */
                break;
            //Up
            case 2: sprite = up;
                /*
                if (anim < stage1) sprite = up1;
                else if (anim < stage2) sprite = up;
                else if (anim < stage3) sprite = up2;
                else if (anim < stage4) sprite = up;
                */
                break;
            //Right
            case 3:case 5:case 8: sprite = right;
                /*
                if (anim < stage1) sprite = right1;
                else if (anim < stage2) sprite = right;
                else if (anim < stage3) sprite = right2;
                else if (anim < stage4) sprite = right;
                */
                break;
            case 7: sprite = down;
                /*
                if (anim < stage1) sprite = down1;
                else if (anim < stage2) sprite = down;
                else if (anim < stage3) sprite = down2;
                else if (anim < stage4) sprite = down;
                */
                break;
        }
    }

    //STAT METHODS
    public int getHP() {
        return hp;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getMP() {
        return mp;
    }
    public int getMaxMP() {
        return maxMP;
    }
}
