package mob.players;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

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
        mp = maxMP = 5;
        speed = baseSpeed = 12;
    }

}
