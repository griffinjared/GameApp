package rooms.common_rooms;

import android.content.Context;

import mob.enemies_1_forest.Sapling;
import mob.enemies_2_caves.Troll;
import mob.players.Player;
import rooms.Room;

public class Exit_Room extends Room {

    public Exit_Room(Context context, Player player, int doorLayout, String level) {
        super(context);
        name = "Exit_Room";

        /** The Exit Room contains the tile that leads to the next area upon being touched
         *  The player should be prompted to continue before going to the next level
         */

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);

        switch(level) {
            case "Forest":
                enemies.add(new Sapling(1, 1, context, player));
                enemies.add(new Sapling(10, 1, context, player));
                enemies.add(new Sapling(1, 10, context, player));
                enemies.add(new Sapling(10, 10, context, player));
                break;
            case "Caves":
                enemies.add(new Troll(1, 1, context, player));
                enemies.add(new Sapling(10, 1, context, player));
                enemies.add(new Sapling(1, 10, context, player));
                enemies.add(new Troll(10, 10, context, player));
        }

    }
}
