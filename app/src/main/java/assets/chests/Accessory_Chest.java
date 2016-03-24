package assets.chests;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import equipment.accessory.Accessory;

public class Accessory_Chest extends Chest {

    private Accessory accessory;

    public Accessory_Chest(int x, int y, Context context, Accessory a) {
        super(x, y, context);

        accessory = a;
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.tiles_level1_forest), 3);
    }

}
