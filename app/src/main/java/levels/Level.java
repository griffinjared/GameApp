package levels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

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

    protected Context context;

    /* There will only ever be one room active at a time on-screen
     * So the currentRoom variable will always be set to the active room, and is what's actually used to render
     */
    protected Room currentRoom;
    protected ArrayList<Room> rooms;
    protected char[][] levelLayout;
    protected int roomX = 0, roomY = 0;

    //These Tiles will always have the same names and functions but different sprites depending on the level
    public static Tile Wall = new Tile(); //Boundaries around the room

    public static Tile Floor1 = new Tile(); //Anything you can walk over normally
    public static Tile Floor2 = new Tile();
    public static Tile Floor3 = new Tile();
    public static Tile Floor4 = new Tile();

    public static Tile Solid1 = new Tile(); //Something that isn't a wall but also can't be walked over or through
    public static Tile Solid2 = new Tile();
    public static Tile Solid3 = new Tile();
    public static Tile Solid4 = new Tile();

    public static Tile Exit = new Tile();

    public Level(Context context) {
        this.context = context;
        rooms = new ArrayList<Room>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room changeRoom(int RoomX, int roomY) {
        return currentRoom;
    }

    //Reusable tiles will have their sprites changed per level
    public void changeTilesSprites(Bitmap sprites) {
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprites, 96, 144, true);

        int size = Tile.SIZE;

        Wall.setSprite(Bitmap.createBitmap(spriteSheet, 0, size, size, size));

        Floor1.setSprite(Bitmap.createBitmap(spriteSheet, 0, 0, size, size));
        Floor2.setSprite(Bitmap.createBitmap(spriteSheet, size, 0, size, size));
        Floor3.setSprite(Bitmap.createBitmap(spriteSheet, 2*size, 0, size, size));
        Floor4.setSprite(Bitmap.createBitmap(spriteSheet, 3*size, 0, size, size));

        Solid1.setSprite(Bitmap.createBitmap(spriteSheet, 0, 2*size, size, size));
        Solid2.setSprite(Bitmap.createBitmap(spriteSheet, size, 2*size, size, size));
        Solid3.setSprite(Bitmap.createBitmap(spriteSheet, 2*size, 2*size, size, size));
        Solid4.setSprite(Bitmap.createBitmap(spriteSheet, 3*size, 2*size, size, size));

        Exit.setSprite(Bitmap.createBitmap(spriteSheet, 0, 3*size, size, size));
    }

    public void update(int switchRoom) {
        switch (switchRoom) {
            case 1: roomY--; break; //North
            case 2: roomX++; break; //East
            case 3: roomY++; break; //South
            case 4: roomX--; break; //West
            default: break;
        }

        if (switchRoom > 0) {
            currentRoom = changeRoom(roomX, roomY);
        }

        currentRoom.update();
    }

    public void draw(Canvas c, Paint p) {
        //Tiles
        for (int y = 0; y < currentRoom.getTileLayout().length; y++) {
            for (int x = 0; x < currentRoom.getTileLayout()[y].length; x++) {
                switch(currentRoom.getTileLayout()[y][x]) {
                    case 0: Wall.draw(c, p, x, y); break;

                    case 1: Floor1.draw(c, p, x, y); break;
                    case 2: Floor2.draw(c, p, x, y); break;
                    case 3: Floor3.draw(c, p, x, y); break;
                    case 4: Floor4.draw(c, p, x, y); break;

                    case 5: Solid1.draw(c, p, x, y); break;
                    case 6: Solid2.draw(c, p, x, y); break;
                    case 7: Solid3.draw(c, p, x, y); break;
                    case 8: Solid4.draw(c, p, x, y); break;

                    case 9: Exit.draw(c, p, x, y); break;

                    default: Floor1.draw(c, p, x, y); break;
                }
            }
        }

        //Enemies,chests, and items
        currentRoom.draw(c, p);
    }

    public int getRoomX() {
        return roomX;
    }

    public int getRoomY() {
        return roomY;
    }

    public Context getContext() {
        return context;
    }
}
