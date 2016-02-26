package levels;

import android.content.Context;
import android.graphics.Bitmap;

import rooms.Room;
import rooms.common_rooms.Empty_Room;
import rooms.common_rooms.Exit_Room;
import rooms.common_rooms.Spawn_Room;

public class Level_1_Forest extends Level {

    //List of rooms
    private Spawn_Room spawn;
    private Exit_Room exit;
    private Empty_Room empty;

    public Level_1_Forest(Context context, Bitmap spriteSheet) {
        super(context);
        changeTilesSprites(spriteSheet);

        levelLayout = new char[][] {
                {'E', 'E', 'E'},
                {'X', 'S', 'E'},
                {'E', 'E', 'E'}
        };

        //Level-specific
        spawn = new Spawn_Room(context, 0);
        exit = new Exit_Room(context, 0);
        empty = new Empty_Room(context, 0);
        currentRoom = spawn;

        roomY = 1;
        roomX = 1;
    }

    public Room changeRoom(int roomX, int roomY) {
        int roomCode = levelLayout[roomY][roomX];

        switch(roomCode) {
            case 'S': return spawn;
            case 'X': return exit;
            case 'E': return empty;
        }

        return currentRoom;
    }

}
