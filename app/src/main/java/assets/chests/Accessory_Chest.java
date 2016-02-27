package assets.chests;

import android.graphics.Bitmap;

public class Accessory_Chest extends Chest {

    public Accessory_Chest(int x, int y, Bitmap spriteSheet, int id) {
        super(x, y);

        setSprites(spriteSheet, 3);
    }

}
