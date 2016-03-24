package assets.chests;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import equipment.spell.Spell;

public class Spell_Chest extends Chest {

    private Spell spell;

    public Spell_Chest(int x, int y, Context context, Spell s) {
        super(x, y, context);

        spell = s;
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest), 2);
    }

}