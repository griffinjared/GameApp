package equipment.armor;

import android.graphics.Bitmap;

public class Shield extends Armor {

    public Shield(int x, int y, Bitmap spriteSheet) {
        super(x, y);

        name = "Shield";
        sprite = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        physicalBuffer = .1f;
        magicalBuffer = .1f;
    }

}
