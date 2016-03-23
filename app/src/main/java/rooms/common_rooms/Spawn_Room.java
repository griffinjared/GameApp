package rooms.common_rooms;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import assets.chests.Weapon_Chest;
import mob.enemies_1_forest.Fouling;
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

        enemies.add(new Fouling(10, 10, context));
    }
}
