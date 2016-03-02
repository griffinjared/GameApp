package assets.chests;

import android.graphics.Bitmap;

import equipment.accessory.Accessory;

public class Accessory_Chest extends Chest {

    private Accessory accessory;

    public Accessory_Chest(int x, int y, Bitmap spriteSheet, Accessory a) {
        super(x, y);

        accessory = a;
        setSprite(spriteSheet, 3);
    }

}
