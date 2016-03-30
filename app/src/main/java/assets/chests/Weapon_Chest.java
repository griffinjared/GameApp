package assets.chests;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import equipment.accessory.Accessory;
import equipment.weapon.Weapon;

public class Weapon_Chest extends Chest {

    private Weapon weapon;

    public Weapon_Chest(int x, int y, Context context, Weapon w) {
        super(x, y, context);

        weapon = w;
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest), 0);
    }

}
