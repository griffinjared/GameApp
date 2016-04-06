package rooms.stage2_caves;

import android.content.Context;

import rooms.Room;

public class Talis_Cave extends Room {

    public Talis_Cave(Context context, int doorLayout) {
        super(context);
        name = "Talis_Cave";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 8, 2, 2, 2, 1, 2, 2, 2, 2, 0},
                {0, 8, 8, 8, 8, 2, 2, 1, 1, 2, 2, 0},
                {0, 2, 2, 8, 8, 2, 2, 1, 8, 1, 2, 0},
                {0, 2, 2, 2, 8, 8, 8, 8, 8, 2, 2, 0},
                {0, 2, 2, 2, 2, 8, 8, 2, 2, 2, 1, 0},
                {0, 1, 2, 2, 8, 8, 2, 2, 2, 2, 2, 0},
                {0, 2, 1, 2, 8, 8, 8, 2, 2, 2, 1, 0},
                {0, 2, 1, 8, 2, 2, 8, 8, 2, 1, 2, 0},
                {0, 2, 2, 2, 1, 1, 2, 1, 2, 2, 1, 0},
                {0, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }

}
