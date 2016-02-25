package assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Andrew on 2/24/2016.
 */
public class Chest {

    private int x, y;
    public static final int SIZE = 24;
    protected Bitmap sprite_closed, sprite_opened;
    private boolean opened = false;

    /** Chests contained treasure, as you may have guessed
     *  Eventually, there will probably be multiple chest constructors depending on if they carry, money, weapons, keys, etc.
     *  Its sprites will also change depending on the current level since we're going for multiple aesthetics.
     */

    public Chest(int x, int y, Bitmap spriteSheet) {
        this.x = x;
        this.y = y;

        //Change sprites based on level (or rather, the spriteSheet contained in the level)
        setSprites(spriteSheet);
    }

    public void setSprites(Bitmap sprites) {
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprites, 144, 288, true);

        sprite_closed = Bitmap.createBitmap(spriteSheet, 0, 6*SIZE, SIZE, SIZE);
        sprite_opened = Bitmap.createBitmap(spriteSheet, SIZE, 6*SIZE, SIZE, SIZE);
    }

    public void draw(Canvas c, Paint p) {
        if (opened) c.drawBitmap(sprite_opened, x*SIZE, y*SIZE, p);
        else c.drawBitmap(sprite_closed, x*SIZE, y*SIZE, p);
    }

    public boolean isOpen() {
        return opened;
    }

}
