package assets.chests;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import equipment.armor.Armor;

public class Armor_Chest extends Chest {

    private Armor armor;

    public Armor_Chest(int x, int y, Context context, Armor a) {
        super(x, y, context);

        armor = a;
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest), 1);
    }

}