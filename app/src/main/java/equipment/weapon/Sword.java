package equipment.weapon;

import android.graphics.Bitmap;

public class Sword extends Weapon {

    public Sword(int x, int y, Bitmap spriteSheet) {
        super(x, y);

        name = "Sword";
        sprite = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        damage = 2;
        forwardRange = 1.5f;
        sideRange = 0f;
    }

}
