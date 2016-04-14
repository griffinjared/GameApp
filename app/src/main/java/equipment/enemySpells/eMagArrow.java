package equipment.enemySpells;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import mob.Mob;

/** Starting spell for the Mage player class */

public class eMagArrow extends eSpell {

    public eMagArrow(int x, int y, Context context, Mob mob, int mag) {
        super(x, y, context, mob, mag);

        name = "Magic Arrow";
        damage = 1;
        cost = 1;
        forwardRange = 5;
        sideRange = 0;

        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.spells), 0, 0);
    }

}
