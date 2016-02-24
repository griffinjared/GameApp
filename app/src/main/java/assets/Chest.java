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

    public Chest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSprite(Bitmap sprite1, Bitmap sprite2) {
        this.sprite_closed = Bitmap.createScaledBitmap(sprite1, SIZE, SIZE, true);
        this.sprite_opened = Bitmap.createScaledBitmap(sprite2, SIZE, SIZE, true);
    }

    public void draw(Canvas c, Paint p) {
        if (opened) c.drawBitmap(sprite_opened, x*SIZE, y*SIZE, p);
        else c.drawBitmap(sprite_closed, x*SIZE, y*SIZE, p);
    }

    public boolean isOpen() {
        return opened;
    }

}
