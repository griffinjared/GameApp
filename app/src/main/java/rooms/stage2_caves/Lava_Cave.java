package rooms.stage2_caves;

import android.content.Context;

import rooms.Room;

public class Lava_Cave extends Room {

    public Lava_Cave(Context context, int doorLayout) {
        super(context);
        name = "Lava_Cave";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 7, 7, 7, 1, 1, 2, 1, 1, 2, 0},
                {0, 1, 1, 7, 7, 7, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 7, 7, 7, 1, 1, 2, 1, 0},
                {0, 1, 2, 1, 7, 7, 7, 7, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 7, 7, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 7, 2, 2, 1, 1, 1, 0},
                {0, 1, 1, 2, 1, 1, 2, 2, 7, 7, 1, 0},
                {0, 2, 1, 1, 1, 1, 1, 7, 7, 7, 7, 0},
                {0, 2, 1, 1, 1, 1, 1, 1, 7, 7, 7, 0},
                {0, 2, 1, 1, 1, 1, 2, 1, 7, 7, 7, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }

}
