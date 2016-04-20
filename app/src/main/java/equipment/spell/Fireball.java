package equipment.spell;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

/** Starting spell for the Mage player class */

public class Fireball extends Spell {

    public Fireball(int x, int y, Context context) {
        super(x, y, context);

        name = "Magic Arrow";
        damage = 1;
        cost = 1;
        forwardRange = 5;
        sideRange = 0;
        direction = 0;
        speed = 4;

        System.gc();
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.spells), 1, 0);
    }

}
