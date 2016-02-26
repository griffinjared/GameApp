package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/** The Mob class can be anything that moves around in the map, not just enemies.
 *  As such, the Player is a Mob as well.
 */
public class Mob {

    protected final int SIZE = 24;
    public static int x, y;
    protected Bitmap spriteSheet; //Image where all the sprites are stored
    protected Bitmap sprite; //Primary, currently-active sprite

    //Sprites
    protected static Bitmap down, down1, down2;
    protected static Bitmap up, up1, up2;
    protected static Bitmap left, left1, left2;
    protected static Bitmap right, right1, right2;

    //Statistics
    protected int hp, mp, level, speed;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int num) {
        x += num;
    }
    public void setY(int num) {
        y += num;
    }

    public void draw(Canvas c, Paint p) {

        c.drawBitmap(sprite, x, y, p);
    }

}
