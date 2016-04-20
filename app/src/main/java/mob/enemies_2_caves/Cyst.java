package mob.enemies_2_caves;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

import java.lang.Override;

import equipment.enemySpells.eMagArrow;
import equipment.enemySpells.eMagmaRock;
import equipment.enemySpells.eSpell;
import mob.Enemy;
import mob.players.Player;
import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Cyst extends Enemy {

    private eSpell magic1, magic2, magic3, magic4;
    private Context context;

    public Cyst(int x, int y, Context context, Player player) {
        super(x, y, player);
        this.context = context;

        magic1 = new eSpell(x, y, context, player);
        magic2 = new eSpell(x, y, context, player);
        magic3 = new eSpell(x, y, context, player);
        magic4 = new eSpell(x, y, context, player);
        Bitmap sprites = BitmapFactory.decodeResource(context.getResources(), R.drawable.caves_enemy_cyst);
        setSprites(sprites);

        hp = maxHP = 3;
        mp = maxMP = 4;
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

            magic1 = new eMagmaRock(getX(), getY(), context, player, mag, 2);
            magic2 = new eMagmaRock(getX(), getY(), context, player, mag, 4);
            magic3 = new eMagmaRock(getX(), getY(), context, player, mag, 6);
            magic4 = new eMagmaRock(getX(), getY(), context, player, mag, 8);

            setMP(-1);
            sprite = atk_down;
        }

        magic1.update(); magic2.update(); magic3.update(); magic4.update();

    }

    @Override
    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x, y, p);

        if (magic1 != null) {
            magic1.draw(c, p);
            magic2.draw(c, p);
            magic3.draw(c, p);
            magic4.draw(c, p);
        }

    }
}
