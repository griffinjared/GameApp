package levels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

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

    protected int SIZE;

    protected Context context;

    /* There will only ever be one room active at a time on-screen
     * So the currentRoom variable will always be set to the active room, and is what's actually used to render
     */
    protected Room currentRoom;

    //These Tiles will always have the same names and functions but different sprites depending on the level
    public static Tile Wall = new Tile(); //Boundaries around the room

    public static Tile Floor0 = new Tile(); //Anything you can walk over normally
    public static Tile Floor1 = new Tile();
    public static Tile Floor2 = new Tile();

    public static Tile Solid0 = new Tile(); //Something that isn't a wall but also can't be walked over or through

    public Level(Context context, int size) {
        this.context = context;
        SIZE = size;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    //Reusable tiles will have their sprites changed per level
    public void changeTilesSprites(Bitmap spriteSheet) {
        int size = Tile.SIZE;

        Floor0.setSprite(Bitmap.createBitmap(spriteSheet, 0*size, 0*size, size, size));
        Floor1.setSprite(Bitmap.createBitmap(spriteSheet, 1*size, 0*size, size, size));
        Floor2.setSprite(Bitmap.createBitmap(spriteSheet, 2*size, 0*size, size, size));
        Wall.setSprite(Bitmap.createBitmap(spriteSheet, 0*size, 1*size, size, size));
    }

    public void draw(Canvas c, Paint p) {
        //Tiles
        for (int y = 0; y < currentRoom.getTileLayout().length; y++) {
            for (int x = 0; x < currentRoom.getTileLayout()[y].length; x++) {
                switch(currentRoom.getTileLayout()[y][x]) {
                    case 0: Level.Floor0.draw(c, p, x, y); break;
                    case 1: Level.Wall.draw(c, p, x, y); break;
                    case 2: Level.Floor1.draw(c, p, x, y); break;
                    case 3: Level.Floor2.draw(c, p, x, y); break;
                    default: Level.Floor0.draw(c, p, x, y); break;
                }
            }
        }

        //Treasures
        for (int i = 0; i < currentRoom.getTreasures().size(); i++) {
            currentRoom.getTreasures().get(i).draw(c, p);
        }
    }

}
