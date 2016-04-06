package rooms.stage1_forest;

import android.content.Context;

import rooms.Room;

public class River_Room extends Room {

    public River_Room(Context context, int doorLayout) {
        super(context);
        name = "River_Room";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 6, 6, 6, 1, 1, 2, 4, 4, 2, 0},
                {0, 1, 1, 6, 6, 6, 7, 1, 4, 4, 4, 0},
                {0, 4, 1, 1, 6, 6, 6, 1, 1, 4, 4, 0},
                {0, 4, 2, 1, 7, 6, 6, 6, 1, 1, 4, 0},
                {0, 4, 4, 1, 1, 6, 6, 3, 1, 1, 1, 0},
                {0, 4, 4, 4, 1, 6, 3, 3, 3, 1, 1, 0},
                {0, 4, 4, 4, 1, 1, 3, 3, 6, 7, 1, 0},
                {0, 2, 4, 4, 4, 1, 1, 6, 6, 6, 6, 0},
                {0, 2, 4, 4, 4, 4, 1, 1, 6, 6, 6, 0},
                {0, 2, 4, 4, 4, 4, 2, 1, 7, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }

}
