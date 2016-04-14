package equipment.enemySpells;

import android.content.Context;

import equipment.Equipment;
import mob.Mob;

/** Spells are the player's only ranged attacks (besides special items) and consume MP on use
 */

public class eSpell extends Equipment {

    protected Mob mob;

    protected int x, y;
    protected int damage;
    protected int cost;
    protected int forwardRange;
    protected int sideRange;

    public eSpell(int x, int y, Context context, Mob mob, int mag) {
        super(x, y, context);

        this.mob = mob;
        damage *= mag;
    }

    public void update() {
        if (x < mob.getX()) {
            x++;
        }
        else if (x > mob.getY()) {
            x--;
        }

        if (y < mob.getY()) {
            y++;
        }
        else if (y > mob.getY()) {
            y--;
        }

        if (Math.abs(x - mob.getX()) <= 12 && Math.abs(y - mob.getY()) <= 12) {
            damage();
        }
    }

    public void damage() {
        mob.setHP(-damage);
    }

}
