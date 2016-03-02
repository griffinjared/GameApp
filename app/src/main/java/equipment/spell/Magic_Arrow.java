package equipment.spell;

import android.graphics.Bitmap;

/** Starting spell for the Mage player class */

public class Magic_Arrow extends Spell {

    public Magic_Arrow(int x, int y, Bitmap spriteSheet) {
        super(x, y);

        name = "Magic Arrow";
        sprite = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        damage = 1;
        cost = 5;
        forwardRange = 5;
        sideRange = 0;
    }

}
