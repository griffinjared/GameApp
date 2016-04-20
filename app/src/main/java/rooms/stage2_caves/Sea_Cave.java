package rooms.stage2_caves;

import android.content.Context;

import mob.enemies_2_caves.Cyst;
import mob.enemies_2_caves.Troll;
import mob.players.Player;
import rooms.Room;

public class Sea_Cave extends Room {

    public Sea_Cave(Context context, Player player, int doorLayout) {
        super(context);
        name = "Sea_Cave";

        tileLayout = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 6, 6, 6, 1, 1, 3, 4, 4, 3, 0},
                {0, 1, 1, 6, 6, 6, 5, 1, 4, 4, 4, 0},
                {0, 4, 1, 1, 6, 6, 6, 1, 1, 4, 4, 0},
                {0, 4, 3, 1, 5, 6, 6, 6, 1, 1, 4, 0},
                {0, 4, 4, 1, 1, 6, 6, 3, 1, 1, 1, 0},
                {0, 4, 4, 4, 1, 6, 3, 3, 3, 1, 1, 0},
                {0, 4, 4, 4, 1, 1, 3, 3, 6, 5, 1, 0},
                {0, 3, 4, 4, 4, 1, 1, 6, 6, 6, 6, 0},
                {0, 3, 4, 4, 4, 4, 1, 1, 6, 6, 6, 0},
                {0, 3, 4, 4, 4, 4, 3, 1, 5, 6, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        defineDoorLayout(doorLayout);

        enemies.add(new Cyst(6, 8, context, player));
        enemies.add(new Troll(7, 5, context, player));
    }

}
