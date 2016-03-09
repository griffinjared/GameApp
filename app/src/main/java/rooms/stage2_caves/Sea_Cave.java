package rooms.stage2_caves;

import android.content.Context;

import rooms.Room;

public class Sea_Cave extends Room {

    public Sea_Cave(Context context, int doorLayout) {
        super(context);

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 6, 6, 6, 1, 1, 3, 4, 4, 3, 0},
                {0, 1, 1, 6, 6, 6, 5, 1, 4, 4, 4, 0},
                {0, 4, 1, 1, 6, 6, 6, 1, 1, 4, 4, 0},
                {0, 4, 3, 1, 5, 6, 6, 6, 1, 1, 4, 0},
                {0, 4, 4, 1, 1, 6, 6, 3, 1, 1, 1, 0},
                {0, 4, 4, 4, 1, 6, 3, 3, 3, 1, 1, 0},
                {0, 4, 4, 4, 1, 1, 3, 3, 6, 5, 1, 0},
                {0, 3, 4, 4, 4, 1, 1, 6, 6, 6, 6, 0},
                {0, 3, 4, 4, 4, 4, 1, 1, 6, 6, 6, 0},
                {0, 3, 4, 4, 4, 4, 3, 1, 5, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }

}
