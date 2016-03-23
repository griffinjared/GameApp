package mob.enemies_1_forest;

import android.graphics.Bitmap;

import mob.Enemy;
import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Fouling extends Enemy {

    public Fouling(int x, int y, Bitmap sprites) {
        super(x, y, sprites);

        hp = maxHP = 2;
        mp = maxMP = 0;
        speed = baseSpeed = 1;
    }

    @Override
    public void update(Room room) {
        randomMovement(room);
    }

}
