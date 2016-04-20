package equipment.enemySpells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import equipment.Equipment;
import mob.Mob;

/** Spells are the player's only ranged attacks (besides special items) and consume MP on use
 */

public class eSpell extends Equipment {

    protected Mob mob;

    protected int spd;
    protected int damage;
    protected int cost;
    protected int forwardRange;
    protected int sideRange;
    protected boolean hit = false;

    public eSpell(int x, int y, Context context, Mob mob, int mag) {
        super(x, y, context);

        this.mob = mob;
        damage *= mag;
    }

    public void update() {

    }

    public void draw(Canvas c, Paint p) {

    }

    public void damage() {
        mob.setHP(-damage);
        hit = true;
    }

    public boolean isFinished() {
        return hit;
    }

}
