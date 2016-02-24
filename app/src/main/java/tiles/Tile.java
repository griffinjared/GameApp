package tiles;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.Screen;

/** Right now, the Tile class is simply the holder of an image that is 24x24 pixels
 *  Each Tile also has unique coordinates for its placement in a Room
 *  All Tiles are contained in Room classes
 */


public class Tile {

    //Position in the individual room
    protected final int X, Y;
    public static final int SIZE = 24;

    protected Bitmap sprite;
    protected Resources res;

    public Tile(int x, int y, Resources res) {
        X = x;
        Y = y;
        this.res = res;
    }

    public void draw(Canvas c, Paint p) {

        c.drawBitmap(sprite, X*SIZE, Y*SIZE, p);
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

}
