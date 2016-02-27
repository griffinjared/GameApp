package assets.chests;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Chest {

    protected int x, y;
    public static final int SIZE = 24;
    protected Bitmap sprite;
    protected boolean opened = false;

    /** Chests contained treasure, as you may have guessed
     *  Eventually, there will probably be multiple chest constructors depending on if they carry, money, weapons, keys, etc.
     *  Its sprites will also change depending on the current level since we're going for multiple aesthetics.
     */

    public Chest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSprites(Bitmap sprites, int num) {
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprites, 96, 144, true);

        sprite = Bitmap.createBitmap(spriteSheet, num*SIZE, 4*SIZE, SIZE, SIZE);
    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x*SIZE, y*SIZE, p);
    }

    public boolean isOpen() {
        return opened;
    }

    public void open() {
        opened = true;
    }

}
