package levels;

import android.content.Context;

import rooms.Room;
import tiles.Tile;

/** The Level class is an assortment of randomized Rooms
 *  Only one Level is active at any time, and can be changed into subclasses as the game progresses
 *  For example:
 *      Level level = new Level();
 *      level = new Level1();  <-- This is legitimate
 *      level = new Level2();
 */

public class Level {

    protected final int SIZE;

    protected Context context;

    /* There will only ever be one room active at a time on-screen
     * So the currentRoom variable will always be set to the active room, and is what's actually used to render
     */
    protected Room currentRoom;

    public Level(Context context, int size) {
        this.context = context;
        SIZE = size;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    //These Tiles will always have the same names and functions but different sprites depending on the level
    public static Tile Wall; //Boundaries around the room
    public static Tile Floor0, Floor1, Floor2; //Anything you can walk over normally
    public static Tile Solid0; //Something that isn't a wall but also can't be walked over or through

}
