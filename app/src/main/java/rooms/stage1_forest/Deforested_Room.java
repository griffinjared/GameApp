package rooms.stage1_forest;

import android.content.Context;

import rooms.Room;

public class Deforested_Room extends Room {

    public Deforested_Room(Context context, int doorLayout) {
        super(context);

        tileLayout = new int[][] {
                {0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 5, 0},
                {0, 0, 5, 5, 5, 1, 1, 5, 5, 5, 5, 0},
                {5, 5, 5, 5, 1, 1, 1, 5, 5, 5, 5, 5},
                {0, 1, 5, 5, 1, 1, 1, 5, 1, 0, 5, 0},
                {0, 1, 1, 0, 1, 5, 1, 5, 1, 5, 1, 0},
                {0, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 5, 5, 1, 0, 5, 1, 1, 1, 0},
                {0, 5, 1, 5, 1, 1, 1, 1, 1, 5, 1, 0},
                {5, 5, 1, 1, 1, 5, 1, 1, 0, 5, 1, 5},
                {0, 1, 0, 5, 1, 1, 5, 5, 5, 1, 1, 5},
                {5, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 0},
                {5, 5, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0}
        };

        defineDoorLayout(doorLayout);
    }

}
