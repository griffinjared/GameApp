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

        for (int y = 0; y < levelLayout.length; y++) {
            for (int x = 0; x < levelLayout[y].length; x++) {
                switch(levelLayout[y][x]) {
                    case 'E': rooms.add(new Empty_Room(context, 0)); break;
                    case 'S': rooms.add(new Spawn_Room(context, 0)); break;
                    case 'X': rooms.add(new Exit_Room(context, 0)); break;
                    default: break;
                }
            }
        }

        roomY = 1;
        roomX = 1;
        currentRoom = rooms.get(roomX + (roomY*levelLayout[roomX].length));
    }

    public Room changeRoom(int roomX, int roomY) {
        return rooms.get(roomX + (roomY*levelLayout[roomX].length));
    }

}
