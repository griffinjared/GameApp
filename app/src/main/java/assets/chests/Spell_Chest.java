package assets.chests;

import android.graphics.Bitmap;

import equipment.spell.Spell;

public class Spell_Chest extends Chest {

    private Spell spell;

    public Spell_Chest(int x, int y, Bitmap spriteSheet, Spell s) {
        super(x, y);

        spell = s;

        setSprite(spriteSheet, 2);
    }

}