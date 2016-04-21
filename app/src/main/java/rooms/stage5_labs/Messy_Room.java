package rooms.stage5_labs;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 4/21/2016.
 */
public class Messy_Room extends Room{
    public Messy_Room(Context context, int doorLayout) {
        super(context);
        name = "Messy Room";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 1, 1, 1, 1, 1, 1, 1, 8, 4, 0},
                {0, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 0},
                {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 4, 1, 1, 4, 1, 8, 1, 1, 0},
                {0, 1, 2, 1, 1, 1, 1, 7, 2, 1, 2, 0},
                {0, 6, 1, 1, 4, 1, 1, 1, 1, 1, 1, 0},
                {0, 3, 1, 2, 1, 1, 1, 1, 2, 1, 7, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 2, 5, 1, 1, 2, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }

}
