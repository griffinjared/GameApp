package rooms;

import android.content.Context;

public class Room_Demo extends Room {

    public Room_Demo(Context context) {
        super(context);

        /** This "map" represented by the tileLayout is a representation of how the room will be rendered
         *  Here's the key right now:
         *  0 = Null (Empty Space. Nothing is rendered over the background)
         *  1 = Wall
         */

        tileLayout = new int[][] {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 2, 2, 2, 0, 0, 0, 2, 0, 0, 1},
                {1, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1},
                {1, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
    }

}
