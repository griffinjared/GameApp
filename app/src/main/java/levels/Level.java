package levels;

import android.content.Context;

import rooms.Room;

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
    protected Room currentRoom;

    public Level(Context context, int size) {
        this.context = context;
        SIZE = size;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}
