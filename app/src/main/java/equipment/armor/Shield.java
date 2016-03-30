package equipment.armor;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

public class Shield extends Armor {

    public Shield(int x, int y, Context context) {
        super(x, y, context);

        name = "Shield";
        physicalBuffer = .1f;
        magicalBuffer = .1f;

        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.armors), 0, 0);
    }

}
