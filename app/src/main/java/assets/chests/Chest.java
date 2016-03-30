package assets.chests;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Chest {

    protected int x, y;
    public static final int SIZE = 24;
    protected Bitmap sprite;
    protected boolean opened = false;
    protected Context context;

    /** Chests contained treasure, as you may have guessed
     *  Eventually, there will probably be multiple chest constructors depending on if they carry, money, weapons, keys, etc.
     *  Its sprites will also change depending on the current level since we're going for multiple aesthetics.
     */

    public Chest(int x, int y, Context context) {
        this.x = x;
        this.y = y;
        this.context = context;
    }

    public void setSprite(Bitmap sprite, int num) {
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprite, 96, 144, true);

        this.sprite = Bitmap.createBitmap(spriteSheet, num*SIZE, 4*SIZE, SIZE, SIZE);
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
