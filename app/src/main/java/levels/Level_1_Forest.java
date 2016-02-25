package levels;

import android.content.Context;
import android.graphics.Bitmap;

import rooms.common_rooms.Exit_Room;
import rooms.common_rooms.Spawn_Room;

public class Level_1_Forest extends Level {

    //List of rooms
    private Spawn_Room spawn;
    private Exit_Room exit;

    public Level_1_Forest(Context context, int size, Bitmap spriteSheet) {
        super(context, size);
        changeTilesSprites(spriteSheet);

        //Level-specific
        spawn = new Spawn_Room(context, 0);
        exit = new Exit_Room(context, 0);
        currentRoom = exit;
    }

}
