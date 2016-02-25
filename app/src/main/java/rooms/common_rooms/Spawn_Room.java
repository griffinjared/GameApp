package rooms.common_rooms;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import assets.Chest;
import rooms.Room;

/**
 * Created by griff on 2/24/2016.
 */
public class Spawn_Room extends Room {

    public Spawn_Room(Context context, int doorLayout) {
        super(context);

        /** This "map" represented by the tileLayout is a representation of how the room will be rendered
         *  Here's the key right now:
         *  0 = Wall (Usually surrounding border that prevents player from walking off-screen without a doorway)
         *
         *  1 = Floor, Type 1
         *  2 = Floor, Type 2
         *  3 = Floor, Type 3
         *
         *  4 = Obstacle, Type 1 (Anything that isn't a wall that still blocks hte player, like rocks or water in the environment)
         */

        /*
         *  Spawn room layout
         *  Has four exits so that it will have four paths for the player to choose from
         *  Otherwise the room is empty
         */
        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);

        treasure.add(new Chest(10, 1, BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest)));
    }
}
