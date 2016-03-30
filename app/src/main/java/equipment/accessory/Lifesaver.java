package equipment.accessory;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import mob.players.Player;

public class Lifesaver extends Accessory {

    private boolean broken = false;

    public Lifesaver(int x, int y, Context context, Player player) {
        super(x, y, context, player);

        name = "Lifesaver";

        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.accessories), 0, 0);
    }

    public void effect() {
        if (player.getHP() == 0 && !broken) {
            player.setHP(2);
            broken = true;
        }
    }

}
