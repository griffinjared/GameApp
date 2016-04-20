package rooms.stage2_caves;

import android.content.Context;

import mob.enemies_2_caves.Cyst;
import mob.players.Player;
import rooms.Room;

public class Lava_Cave extends Room {

    public Lava_Cave(Context context, Player player, int doorLayout) {
        super(context);
        name = "Lava_Cave";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 7, 7, 7, 1, 1, 2, 1, 1, 2, 0},
                {0, 1, 1, 7, 7, 7, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 7, 7, 7, 1, 1, 2, 1, 0},
                {0, 1, 2, 1, 7, 7, 7, 7, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 7, 7, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 7, 2, 2, 1, 1, 1, 0},
                {0, 1, 1, 2, 1, 1, 2, 2, 7, 7, 1, 0},
                {0, 2, 1, 1, 1, 1, 1, 7, 7, 7, 7, 0},
                {0, 2, 1, 1, 1, 1, 1, 1, 7, 7, 7, 0},
                {0, 2, 1, 1, 1, 1, 2, 1, 7, 7, 7, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);

        enemies.add(new Cyst(3, 3, context, player));
        enemies.add(new Cyst(7, 9, context, player));
    }

}
