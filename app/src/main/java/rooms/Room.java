package rooms;

import android.content.Context;

import java.util.ArrayList;

import tiles.Tile;

/** The Room class is essentially an array of Tiles
 *  Each Room will have an integer map of the assortment of Tiles, which are then switched out for actual Tiles
 *  The method getTiles() is called by the Screen class so that each Tile can be individually rendered
 */
public class Room {

    protected ArrayList<Tile> tiles = new ArrayList<Tile>();
    protected int[][] tileLayout;
    protected Context context;

    public Room(Context context) {
        this.context = context;
    }

    public void generateMap() {
        for (int y = 0; y < tileLayout.length; y++) {
            for (int x = 0; x < tileLayout[y].length; x++) {
                switch(tileLayout[y][x]) {
                    //To be implemented later
                    //case 1: tiles.add(new WallTile(x, y, context.getResources())); break;
                    //default: tiles.add(new NullTile(x, y, context.getResources())); break;
                }
            }
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

}
