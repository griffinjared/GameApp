package levels;

import android.content.Context;
import android.graphics.Bitmap;

import rooms.Room;
import rooms.common_rooms.Exit_Room;
import rooms.common_rooms.Spawn_Room;

public class Level_1_Forest extends Level {

    //List of rooms
    private Spawn_Room spawn;
    private Exit_Room exit;

    public Level_1_Forest(Context context, Bitmap spriteSheet) {
        super(context);
        changeTilesSprites(spriteSheet);

        levelLayout = new char[][] {
                {'E', 'S'}
        };

        //Level-specific
        spawn = new Spawn_Room(context, 0);
        exit = new Exit_Room(context, 0);
        currentRoom = spawn;

        roomY = 0;
        roomX = 1;
    }

    public Room changeRoom(int roomX, int roomY) {
        int roomCode = levelLayout[roomY][roomX];

        switch(roomCode) {
            case 'S': return spawn;
            case 'E': return exit;
        }

        return currentRoom;
    }

}
