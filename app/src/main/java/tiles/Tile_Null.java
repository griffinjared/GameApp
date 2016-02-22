package tiles;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/** The NullTile is important because it occupies any empty space in a Room
 *  It literally does nothing, but prevents there being any NULL space in the ArrayList<Tile> in the Room class
 */

public class Tile_Null extends Tile {

    public Tile_Null(int x, int y, Resources res) {
        super(x, y, res);
    }

    //The draw class for a NullTile does nothing
    public void draw(Canvas c, Paint p) {
    }

}
