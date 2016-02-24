package tiles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/** Right now, the Tile class is simply the holder of an image that is 24x24 pixels
 *  Each Tile also has unique coordinates for its placement in a Room
 *  All Tiles are contained in Room classes
 */


public class Tile {
    public static final int SIZE = 24;

    protected Bitmap sprite;

    public Tile() {
    }

    public void draw(Canvas c, Paint p, int x, int y) {
        c.drawBitmap(sprite, x*SIZE, y*SIZE, p);
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
        this.sprite = Bitmap.createScaledBitmap(sprite, SIZE, SIZE, true);
    }

}
