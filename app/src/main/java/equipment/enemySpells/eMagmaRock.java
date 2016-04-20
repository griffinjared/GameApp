package equipment.enemySpells;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

import mob.Mob;

/**
 * Created by Andrew on 4/20/2016.
 */
public class eMagmaRock extends eSpell {

    private int direction;

    public eMagmaRock(int x, int y, Context context, Mob mob, int mag, int direction) {
        super(x, y, context, mob);

        name = "Magma Rock";
        damage = 1 * mag;
        cost = 1;
        spd = 2;
        this.direction = direction;

        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.spells), 2, 0);
    }

    @Override
    public void update() {
        switch(direction) {
            case 1: y--; break;
            case 2: x++; y--; break;
            case 3: x++; break;
            case 4: x++; y++; break;
            case 5: y++; break;
            case 6: x--; y++; break;
            case 7: x--; break;
            case 8: x--; y--; break;
        }

        if (Math.abs(getX() - mob.getX()) <= 0 && Math.abs(getY() - mob.getY()) <= 0) {
            if (!hit) damage();
        }
    }
}
