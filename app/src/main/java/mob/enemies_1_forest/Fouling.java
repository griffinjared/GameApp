package mob.enemies_1_forest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import mob.Enemy;
import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Fouling extends Enemy {

    public Fouling(int x, int y, Context context) {
        super(x, y);

        Bitmap sprites = BitmapFactory.decodeResource(context.getResources(), R.drawable.forest_enemy_fouling);
        setSprites(sprites);

        hp = maxHP = 2;
        mp = maxMP = 0;
        speed = baseSpeed = 1;
    }

    @Override
    public void update(Room room) {
        randomMovement(room);
    }

}
