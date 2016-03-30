package rooms.stage3_underwater;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 3/30/2016.
 */
public class Underwater_Cave extends Room{

    public Underwater_Cave(Context context, int doorLayout) {
        super(context);

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
