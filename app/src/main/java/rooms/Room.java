package rooms;

import android.content.Context;

/** The Room class is essentially an array of Tiles
 *  Each Room will have an integer map of the assortment of Tiles, which are then switched out for actual Tiles
 *  The method getTiles() is called by the Screen class so that each Tile can be individually rendered
 */
public class Room {

    protected int[][] tileLayout;
    protected Context context;

    public Room(Context context) {
        this.context = context;
    }

    public int[][] getTileLayout() {
        return tileLayout;
    }

}
