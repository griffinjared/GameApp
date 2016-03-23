package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

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

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int num) {
        x += (num*SIZE);

        if (num == 1) sprite = right;
        else sprite = left;
    }
    public void setY(int num) {
        y += (num*SIZE);

        if (num == 1) sprite = down;
        else sprite = up;
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

}
