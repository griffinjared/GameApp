package equipment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import tiles.Tile;

/** Equipment includes:
 *  Weapons
 *  Armors
 *  Spells
 *  Accessories
 */

public abstract class Equipment {

    //Coordinates inside of a room
    protected int x, y;

    protected final int SIZE = Tile.SIZE;
    protected String name;
    protected Bitmap sprite;

    public Equipment(int x, int y) {
        this.x = x*SIZE;
        this.y = y*SIZE;
    }

    public String getName() {
        return name;
    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x, y, p);
    }

}
