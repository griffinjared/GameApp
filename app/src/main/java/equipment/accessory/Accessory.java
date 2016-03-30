package equipment.accessory;

import android.content.Context;

import equipment.Equipment;
import mob.players.Player;

public abstract class Accessory extends Equipment {

    protected Player player;

    public Accessory(int x, int y, Context context, Player player) {
        super(x, y, context);
        this.player = player;
    }

    //Stuff happens to player here
    public void effect() {
    }

}
