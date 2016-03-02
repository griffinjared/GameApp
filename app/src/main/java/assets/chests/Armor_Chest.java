package assets.chests;

import android.graphics.Bitmap;

import equipment.armor.Armor;

public class Armor_Chest extends Chest {

    private Armor armor;

    public Armor_Chest(int x, int y, Bitmap spriteSheet, Armor a) {
        super(x, y);

        armor = a;

        setSprite(spriteSheet, 1);
    }

}