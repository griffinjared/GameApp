package rooms;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import assets.Chest;

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

        treasure.add(new Chest(10, 1, BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest)));
    }

}
