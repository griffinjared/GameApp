package rooms.stage5_labs;

import android.content.Context;
import rooms.Room;

/**
 * Created by griff on 4/21/2016.
 */
public class Office extends Room{
    public Office(Context context, int doorLayout) {
        super(context);
        name = "Offices";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 5, 6, 0, 2, 1, 0, 5, 6, 3, 0},
                {0, 1, 4, 1, 0, 1, 1, 0, 1, 1, 4, 0},
                {0, 1, 3, 1, 0, 1, 1, 1, 5, 1, 7, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 3, 1, 1, 1, 1, 4, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 7, 6, 0, 1, 2, 0, 5, 1, 6, 0},
                {0, 3, 1, 1, 0, 1, 1, 1, 1, 2, 4, 0},
                {0, 1, 1, 5, 0, 1, 1, 0, 4, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);
    }
}
