package assets.chests;

import android.graphics.Bitmap;

import equipment.weapon.Weapon;

public class Weapon_Chest extends Chest {

    private Weapon weapon;

    public Weapon_Chest(int x, int y, Bitmap spriteSheet, Weapon w) {
        super(x, y);

        weapon = w;

        setSprite(spriteSheet, 0);
    }

}
