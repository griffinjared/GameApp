package assets.chests;

import android.graphics.Bitmap;

public class Armor_Chest extends Chest {

    public Armor_Chest(int x, int y, Bitmap spriteSheet, int id) {
        super(x, y);

        setSprites(spriteSheet, 1);
    }

}