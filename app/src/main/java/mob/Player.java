package mob;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.gameapp.gameapp.R;

/** The real purpose of the Player class is to provide a sprite and controls
 */
public class Player extends Mob {

    public Player(int x, int y, Resources res) {
        this.x = x;
        this.y = y;
        this.res = res;

        sprite = BitmapFactory.decodeResource(res, R.drawable.player);
        sprite = Bitmap.createScaledBitmap(sprite, SIZE, SIZE, true);
    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
    }



}
