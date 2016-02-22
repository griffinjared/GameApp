package mob;

import android.graphics.Canvas;
import android.graphics.Paint;

/** The real purpose of the Player class is to provide a sprite and controls
 */
public class Player extends Mob {

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas c, Paint p) {
        c.drawText("V", x, y, p);
    }



}
