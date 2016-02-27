package assets.chests;

import android.graphics.Bitmap;

public class Spell_Chest extends Chest {

    public Spell_Chest(int x, int y, Bitmap spriteSheet, int id) {
        super(x, y);

        setSprites(spriteSheet, 2);
    }

}