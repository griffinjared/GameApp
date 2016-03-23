package equipment.accessory;

import equipment.Equipment;
import mob.players.Player;

public abstract class Accessory extends Equipment {

    protected Player player;

    public Accessory(int x, int y, Player player) {
        super(x, y);
        this.player = player;
    }

    //Stuff happens to player here
    public void effect() {
    }

}
