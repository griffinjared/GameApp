package levels;

import android.content.Context;
import android.graphics.Bitmap;

import rooms.common_rooms.Spawn_Room;

/**
 * Created by Andrew on 2/24/2016.
 */
public class Level_1_Forest extends Level {

    //List of rooms
    private Spawn_Room room;

    public Level_1_Forest(Context context, int size, Bitmap spriteSheet) {
        super(context, size);
        changeTilesSprites(spriteSheet);
        room = new Spawn_Room(context, 0);
        currentRoom = room;
    }

}
