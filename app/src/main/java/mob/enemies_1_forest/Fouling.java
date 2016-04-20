package mob.enemies_1_forest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import mob.Enemy;
import mob.players.Player;
import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Fouling extends Enemy {

    public Fouling(int x, int y, Context context, Player player) {
        super(x, y, player);

        System.gc();
        Bitmap sprites = BitmapFactory.decodeResource(context.getResources(), R.drawable.forest_enemy_fouling);
        setSprites(sprites);

        hp = maxHP = 2;
        mp = maxMP = 0;
        speed = baseSpeed = 1;
        pwr = 1;
        mag = 0;

    }

    @Override
    public void update(Room room) {
        long currentTime = System.currentTimeMillis();

        if (Math.abs(currentTime - timer) > 500 && Math.abs(currentTime - timer) < 600) {
            if (sprite == atk_down) sprite = down;
            else if (sprite == atk_up) sprite = up;
            else if (sprite == atk_left) sprite = left;
            else if (sprite == atk_right) sprite = right;
        }

        if (Math.abs(currentTime - timer) > 2500) {
            timer = currentTime;

            randomMovement(room);
        }
    }
}
