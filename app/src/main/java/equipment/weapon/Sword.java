package equipment.weapon;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

public class Sword extends Weapon {

    public Sword(int x, int y, Context context) {
        super(x, y, context);

        name = "Sword";
        damage = 2;
        forwardRange = 1.5f;
        sideRange = 0f;

        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.weapons), 0, 0);
    }

}
