package equipment.spell;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

/** Starting spell for the Mage player class */

public class Magic_Arrow extends Spell {

    public Magic_Arrow(int x, int y, Context context) {
        super(x, y, context);

        name = "Magic Arrow";
        damage = 1;
        cost = 5;
        forwardRange = 5;
        sideRange = 0;

        System.gc();
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.spells), 0, 0);
    }

}
