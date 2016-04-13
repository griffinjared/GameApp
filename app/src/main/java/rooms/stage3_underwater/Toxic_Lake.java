package rooms.stage3_underwater;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 3/30/2016.
 */
public class Toxic_Lake extends Room{

    public Toxic_Lake(Context context, int doorLayout) {
        super(context);
        name = "Toxic_Lake";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 8, 8, 8, 3, 3, 2, 3, 3, 2, 0},
                {0, 3, 3, 8, 8, 8, 3, 3, 3, 3, 3, 0},
                {0, 3, 3, 3, 8, 8, 8, 3, 3, 2, 3, 0},
                {0, 3, 2, 3, 8, 8, 8, 8, 3, 3, 3, 0},
                {0, 3, 3, 3, 3, 8, 8, 2, 3, 3, 3, 0},
                {0, 3, 3, 3, 3, 8, 2, 2, 3, 3, 3, 0},
                {0, 3, 3, 2, 3, 3, 2, 2, 8, 8, 3, 0},
                {0, 2, 3, 3, 3, 3, 3, 8, 8, 8, 8, 0},
                {0, 2, 3, 3, 3, 3, 3, 3, 8, 8, 8, 0},
                {0, 2, 3, 3, 3, 3, 2, 3, 8, 8, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}
