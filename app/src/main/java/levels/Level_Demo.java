package levels;

import android.content.Context;

import rooms.Room_Demo;

/**
 * Created by Andrew on 2/21/2016.
 */
public class Level_Demo extends Level {

    //List of rooms
    private Room_Demo room;

    public Level_Demo(Context context, int size) {
        super(context, size);
        room = new Room_Demo(context);
        currentRoom = room;
    }
}
