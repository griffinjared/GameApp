package mob.enemies_1_forest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

import java.lang.Override;

import equipment.enemySpells.eMagArrow;
import equipment.enemySpells.eSpell;
import mob.Enemy;
import mob.players.Player;
import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Sapling extends Enemy {

    private eSpell magic;
    private Context context;

    public Sapling(int x, int y, Context context, Player player) {
        super(x, y, player);
        this.context = context;

        magic = new eSpell(x, y, context, player, mag);
        Bitmap sprites = BitmapFactory.decodeResource(context.getResources(), R.drawable.forest_enemy_sapling);
        setSprites(sprites);

        hp = maxHP = 2;
        mp = maxMP = 5;
        speed = baseSpeed = 0;
        pwr = 0;
        mag = 1;
    }

    @Override
    public void update(Room room) {
        long currentTime = System.currentTimeMillis();

        if (Math.abs(currentTime - timer) > 1000 && Math.abs(currentTime - timer) < 1500) {
            sprite = down;
        }

        if (Math.abs(currentTime - timer) > 5000) {
            timer = currentTime;

            if (mp == 0) return;

            magic = new eMagArrow(getX(), getY(), context, player, mag);
            setMP(-1);
            sprite = atk_down;
        }

        magic.update();
    }

    @Override
    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x, y, p);

        if (magic != null) {
            magic.draw(c, p);
        }
    }
}
