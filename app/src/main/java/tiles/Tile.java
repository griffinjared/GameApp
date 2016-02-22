package tiles;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Andrew on 2/21/2016.
 */
public class Tile {

    //Position in the individual room
    protected final int X, Y;

    protected Bitmap sprite;
    protected Resources res;

    public Tile(int x, int y, Resources res) {
        X = x;
        Y = y;
        this.res = res;
    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, X*sprite.getWidth(), Y*sprite.getHeight(), p);
    }

}
