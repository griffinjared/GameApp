package rooms.stage5_labs;

import android.content.Context;

import rooms.Room;

/**
 * Created by griff on 3/30/2016.
 */
public class Experiments_Lab extends Room{

    public Experiments_Lab(Context context, int doorLayout) {
        super(context);
        name = "Lab";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 7, 1, 8, 1, 1, 1, 2, 8, 8, 0},
                {0, 4, 1, 4, 1, 1, 1, 1, 1, 7, 8, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 0},
                {0, 1, 1, 1, 8, 1, 1, 1, 1, 1, 8, 0},
                {0, 1, 1, 1, 1, 3, 1, 2, 1, 1, 2, 0},
                {0, 7, 1, 1, 1, 1, 1, 8, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 0},
                {0, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 4, 3, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 3, 7, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}
