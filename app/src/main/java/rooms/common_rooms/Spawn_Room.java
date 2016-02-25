package rooms.common_rooms;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import assets.Chest;
import rooms.Room;

public class Spawn_Room extends Room {

    public Spawn_Room(Context context, int doorLayout) {
        super(context);

        /** Spawn room layout
         *  Has four exits so that it will have four paths for the player to choose from
         *  Otherwise the room is empty
         */

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 2, 2, 2, 1, 4, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 2, 1, 4, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 0},
                {0, 1, 5, 1, 1, 1, 3, 3, 1, 1, 1, 0},
                {0, 1, 1, 6, 1, 1, 3, 3, 1, 1, 1, 0},
                {0, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 8, 8, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);

        treasure.add(new Chest(10, 1, BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest)));
    }
}
