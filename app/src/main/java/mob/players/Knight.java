package mob.players;

import android.graphics.Bitmap;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Knight extends Player {

    public Knight(int x, int y, Bitmap sprites) {
        super(x, y, sprites);

        hp = maxHP = 15;
        mp = maxMP = 5;
        speed = baseSpeed = 1;
    }

}
