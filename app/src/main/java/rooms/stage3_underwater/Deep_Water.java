package rooms.stage3_underwater;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 3/30/2016.
 */
public class Deep_Water extends Room {

    public Deep_Water(Context context, int doorLayout) {
        super(context);
        name = "Deep_Water";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 7, 7, 7, 1, 1, 2, 3, 1, 2, 0},
                {0, 1, 1, 7, 7, 7, 1, 4, 4, 3, 1, 0},
                {0, 1, 1, 1, 7, 7, 7, 1, 1, 2, 4, 0},
                {0, 1, 2, 1, 7, 7, 7, 7, 1, 1, 1, 0},
                {0, 1, 3, 1, 1, 7, 7, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 7, 2, 2, 1, 1, 1, 0},
                {0, 1, 1, 2, 1, 1, 2, 2, 7, 7, 1, 0},
                {0, 2, 4, 1, 1, 1, 3, 7, 7, 7, 7, 0},
                {0, 2, 1, 4, 1, 3, 1, 1, 7, 7, 7, 0},
                {0, 2, 1, 1, 4, 1, 2, 1, 7, 7, 7, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}
