package mob.players;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

import mob.Mob;
import rooms.Room;

/** The real purpose of the Player class is to provide a sprite and controls
 */
public class Player extends Mob {

    /** 1 2 3
     *  4   5
     *  6 7 8
     */

    private int roomX, roomY; //coordinates in the level layout grid

    public Player(int x, int y) {
        super(x, y);
    }

    public int update() {
        if (x <= -SIZE) { //West
            x = (SIZE*12) - SIZE;
            return 4;
        }
        else if (x >= SIZE*12) { //East
            x = 0;
            return 2;
        }
        else if (y <= -SIZE) { //North
            y = (SIZE*12) - SIZE;
            return 1;
        }
        else if (y >= SIZE*12) { //East
            y = 0;
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



}
