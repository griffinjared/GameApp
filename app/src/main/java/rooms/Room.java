package rooms;

import android.content.Context;

import java.util.ArrayList;

import assets.Chest;

/** The Room class is essentially an array of Tiles
 *  Each Room will have an integer map of the assortment of Tiles, which are then switched out for actual Tiles
 *  The method getTiles() is called by the Screen class so that each Tile can be individually rendered
 */
public class Room {

    protected int[][] tileLayout;

    //Chests will typically be put in individually with specific coordinates instead of on the tileLayout grid
    protected ArrayList<Chest> treasure = new ArrayList<Chest>();

    protected Context context;

    public Room(Context context) {
        this.context = context;

        //map tileLayout formation here.

        //add chests to the treasure array here.
    }

    public int[][] getTileLayout() {
        return tileLayout;
    }
    public ArrayList<Chest> getTreasures() {
        return treasure;
    }

}
