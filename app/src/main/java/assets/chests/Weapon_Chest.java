package assets.chests;

import android.graphics.Bitmap;

public class Weapon_Chest extends Chest {

    public Weapon_Chest(int x, int y, Bitmap spriteSheet, int id) {
        super(x, y);

        setSprites(spriteSheet, 0);
    }

}
