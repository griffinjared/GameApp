package mob.players;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import equipment.spell.Fireball;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Knight extends Player {

    public Knight(int x, int y, Context context) {
        super(x, y);

        System.gc();
        Bitmap sprites = BitmapFactory.decodeResource(context.getResources(), R.drawable.knight_sprites);
        setSprites(sprites);

        hp = maxHP = 15;
        mp = maxMP = 10;
        speed = baseSpeed = 6;
        pwr = 2;
        mag = 1;

        spell = new Fireball(-1, -1, context);
    }

}
