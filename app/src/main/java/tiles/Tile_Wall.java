package tiles;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

public class Tile_Wall extends Tile {

    public Tile_Wall(int x, int y, Resources res) {
        super(x, y, res);

        sprite = BitmapFactory.decodeResource(res, R.drawable.wall);
    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
    }

}
