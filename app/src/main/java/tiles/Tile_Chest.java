package tiles;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

public class Tile_Chest extends Tile {

    public Tile_Chest(int x, int y, Resources res) {
        sprite = BitmapFactory.decodeResource(res, R.drawable.chest);
        sprite = Bitmap.createScaledBitmap(sprite, SIZE, SIZE, true);
    }

    public void draw(Canvas c, Paint p, int x, int y) {
        super.draw(c, p, x, y);
    }
}
