package mob;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/** The Mob class can be anything that moves around in the map, not just enemies.
 *  As such, the Player is a Mob as well.
 */
public class Mob {

    protected int x, y;
    protected Bitmap sprite;
    protected Resources res;

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

    }

}
