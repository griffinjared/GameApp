package equipment;

import android.content.Context;
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
    protected Context context;

    public Equipment(int x, int y, Context context) {
        this.x = x*SIZE;
        this.y = y*SIZE;
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x, y, p);
    }

    public void setSprite(Bitmap sprite, int x, int y) {
        System.gc();
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprite, 96, 144, true);

        this.sprite = Bitmap.createBitmap(spriteSheet, x*SIZE, y*SIZE, SIZE, SIZE);
    }

    public int getX() {
        return x/SIZE;
    }
    public int getY() {
        return y/SIZE;
    }

}
