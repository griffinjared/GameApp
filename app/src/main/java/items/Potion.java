package items;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.gameapp.gameapp.R;

import mob.players.Player;

public class Potion extends Item {

    public Potion(int x, int y, Player player, Context context) {
        super(x, y, player, context);

        name = "Potion";

        System.gc();
        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.items), 0, 0);
    }

    public void effect() {
        player.setHP(3);
    }

}
