package items;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import mob.players.Player;

public class Spice extends Item {

    public Spice(int x, int y, Player player, Context context) {
        super(x, y, player, context);

        name = "Spice";

        System.gc();
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.items), 1, 0);
    }

    @Override
    public void effect() {
        player.setMP(10);
    }

}