package rooms;

import android.content.Context;

/**
 * Created by griff on 2/24/2016.
 */
public class Spawn_Room extends Room {

    public Spawn_Room(Context context) {
        super(context);

        /** This "map" represented by the tileLayout is a representation of how the room will be rendered
         *  Here's the key right now:
         *  0 = Null (Empty Space. Nothing is rendered over the background)
         *  1 = Wall
         */

        /*
         *  Spawn room layout
         *  Has four exits so that it will have four paths for the player to choose from
         *  Otherwise the room is empty
         */
        tileLayout = new int[][] {
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1}
        };

        generateMap();
    }
}
