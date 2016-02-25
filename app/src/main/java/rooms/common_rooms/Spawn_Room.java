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
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);

        treasure.add(new Chest(10, 1, BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest)));
    }
}
