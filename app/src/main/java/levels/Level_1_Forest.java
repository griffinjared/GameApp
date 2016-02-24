package levels;

import android.content.Context;
import android.graphics.Bitmap;

import rooms.Room_Demo;

/**
 * Created by Andrew on 2/24/2016.
 */
public class Level_1_Forest extends Level {

    //List of room
    private Room_Demo room;

    public Level_1_Forest(Context context, int size, Bitmap spriteSheet) {
        super(context, size);
        changeTilesSprites(spriteSheet);
        room = new Room_Demo(context);
        currentRoom = room;
    }

}
