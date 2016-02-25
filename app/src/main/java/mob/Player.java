package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/** The real purpose of the Player class is to provide a sprite and controls
 */
public class Player extends Mob {

    public Player(int x, int y, Bitmap spriteSheet) {
        this.x = x;
        this.y = y;
        this.spriteSheet = spriteSheet;

        //Set all sprites
        down = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE); Bitmap.createScaledBitmap(down, SIZE, SIZE, true);
        down1 = Bitmap.createBitmap(spriteSheet, 0, SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(down1, SIZE, SIZE, true);
        down2 = Bitmap.createBitmap(spriteSheet, 0, 2*SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(down2, SIZE, SIZE, true);

        up = Bitmap.createBitmap(spriteSheet, 1, 0, SIZE, SIZE); Bitmap.createScaledBitmap(up, SIZE, SIZE, true);
        up1 = Bitmap.createBitmap(spriteSheet, 1, SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(up1, SIZE, SIZE, true);
        up2 = Bitmap.createBitmap(spriteSheet, 1, 2*SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(up2, SIZE, SIZE, true);

        left = Bitmap.createBitmap(spriteSheet, 2, 0, SIZE, SIZE); Bitmap.createScaledBitmap(left, SIZE, SIZE, true);
        left1 = Bitmap.createBitmap(spriteSheet, 2, SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(left1, SIZE, SIZE, true);
        left2 = Bitmap.createBitmap(spriteSheet, 2, 2*SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(left2, SIZE, SIZE, true);

        right = Bitmap.createBitmap(spriteSheet, 3, 0, SIZE, SIZE); Bitmap.createScaledBitmap(right, SIZE, SIZE, true);
        right1 = Bitmap.createBitmap(spriteSheet, 3, SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(right1, SIZE, SIZE, true);
        right2 = Bitmap.createBitmap(spriteSheet, 3, 2*SIZE, SIZE, SIZE); Bitmap.createScaledBitmap(right2, SIZE, SIZE, true);

        sprite = down;
    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
