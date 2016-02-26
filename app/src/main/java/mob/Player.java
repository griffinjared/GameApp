package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.gameapp.gameapp.MainThread;

/** The real purpose of the Player class is to provide a sprite and controls
 */
public class Player extends Mob {

    private int roomX, roomY; //coordinates in the level layout grid

    public Player(int x, int y, Bitmap sprites) {
        this.x = x*SIZE;
        this.y = y*SIZE;
        this.spriteSheet = Bitmap.createScaledBitmap(sprites, 192, 72, true);

        //Set all sprites
        down = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        down1 = Bitmap.createBitmap(spriteSheet, 0, SIZE, SIZE, SIZE);
        down2 = Bitmap.createBitmap(spriteSheet, 0, 2*SIZE, SIZE, SIZE);

        up = Bitmap.createBitmap(spriteSheet, 1, 0, SIZE, SIZE);
        up1 = Bitmap.createBitmap(spriteSheet, 1, SIZE, SIZE, SIZE);
        up2 = Bitmap.createBitmap(spriteSheet, 1, 2*SIZE, SIZE, SIZE);

        left = Bitmap.createBitmap(spriteSheet, 2, 0, SIZE, SIZE);
        left1 = Bitmap.createBitmap(spriteSheet, 2, SIZE, SIZE, SIZE);
        left2 = Bitmap.createBitmap(spriteSheet, 2, 2*SIZE, SIZE, SIZE);

        right = Bitmap.createBitmap(spriteSheet, 3, 0, SIZE, SIZE);
        right1 = Bitmap.createBitmap(spriteSheet, 3, SIZE, SIZE, SIZE);
        right2 = Bitmap.createBitmap(spriteSheet, 3, 2*SIZE, SIZE, SIZE);

        sprite = down;
    }

    public int update() {
        if (x <= -24) { //West
            x = 288 - 24;
            return 4;
        }
        else if (x >= 288) { //East
            x = 24;
            return 2;
        }
        else if (y <= -24) { //North
            y = 288 - 24;
            return 1;
        }
        else if (y >= 288) { //East
            y = 24;
            return 3;
        }

        return 0;
    }

    public int getRoomX() {
        return roomX;
    }

    public int getRoomy() {
        return roomY;
    }

    public void setLevelPosition(int x, int y) {
        roomX = x;
        roomY = y;
    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
    }
}
