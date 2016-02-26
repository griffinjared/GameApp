package rooms.common_rooms;

import android.content.Context;

import rooms.Room;

public class Empty_Room extends Room {

    public Empty_Room(Context context, int doorLayout) {
        super(context);

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 4, 4, 4, 4, 2, 4, 2, 0},
                {0, 3, 1, 1, 4, 4, 4, 4, 4, 3, 4, 0},
                {0, 1, 4, 4, 4, 4, 4, 4, 2, 2, 4, 0},
                {0, 4, 1, 4, 4, 4, 4, 4, 2, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 2, 2, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 2, 4, 4, 4, 4, 0},
                {0, 4, 1, 4, 4, 4, 4, 4, 4, 1, 4, 0},
                {0, 4, 1, 1, 4, 4, 4, 4, 4, 1, 4, 0},
                {0, 1, 4, 1, 4, 4, 4, 4, 1, 4, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}