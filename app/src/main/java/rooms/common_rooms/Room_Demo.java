package rooms.common_rooms;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import assets.Chest;
import rooms.Room;

public class Room_Demo extends Room {

    public Room_Demo(Context context) {
        super(context);

        /** This "map" represented by the tileLayout is a representation of how the room will be rendered
         *  Here's the key right now:
         *  0 = Null (Empty Space. Nothing is rendered over the background)
         *  1 = Wall
         */

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 2, 2, 2, 1, 1, 1, 3, 1, 1, 0},
                {0, 1, 2, 2, 2, 1, 1, 1, 3, 1, 1, 0},
                {0, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 2, 2, 2, 1, 1, 1, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 0},
                {0, 1, 1, 4, 4, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        treasure.add(new Chest(10, 1, BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest)));
    }

}
