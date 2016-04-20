package rooms.stage4_volcano;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 3/30/2016.
 */
public class Chamber extends Room{

    public Chamber(Context context, int doorLayout) {
        super(context);
        name = "Chamber";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 5, 5, 1, 1, 1, 2, 1, 5, 5, 0},
                {0, 1, 5, 1, 1, 1, 1, 1, 1, 4, 5, 0},
                {0, 1, 1, 5, 1, 1, 1, 1, 5, 2, 5, 0},
                {0, 1, 2, 1, 1, 1, 1, 1, 1, 5, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 5, 0},
                {0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 0},
                {0, 1, 1, 2, 1, 1, 2, 2, 5, 5, 1, 0},
                {0, 2, 3, 5, 1, 1, 1, 1, 5, 5, 4, 0},
                {0, 2, 5, 5, 1, 1, 1, 1, 5, 5, 5, 0},
                {0, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}
