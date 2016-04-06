package rooms.stage3_underwater;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 3/30/2036.
 */
public class Toxic_Lake extends Room{

    public Toxic_Lake(Context context, int doorLayout) {
        super(context);
        name = "Toxic_Lake";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 6, 6, 6, 3, 3, 2, 3, 3, 2, 0},
                {0, 3, 3, 6, 6, 6, 3, 3, 3, 3, 3, 0},
                {0, 3, 3, 3, 6, 6, 6, 3, 3, 2, 3, 0},
                {0, 3, 2, 3, 6, 6, 6, 6, 3, 3, 3, 0},
                {0, 3, 3, 3, 3, 6, 6, 2, 3, 3, 3, 0},
                {0, 3, 3, 3, 3, 6, 2, 2, 3, 3, 3, 0},
                {0, 3, 3, 2, 3, 3, 2, 2, 6, 6, 3, 0},
                {0, 2, 3, 3, 3, 3, 3, 6, 6, 6, 6, 0},
                {0, 2, 3, 3, 3, 3, 3, 3, 6, 6, 6, 0},
                {0, 2, 3, 3, 3, 3, 2, 3, 6, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}
