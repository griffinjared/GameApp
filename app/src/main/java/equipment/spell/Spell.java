package equipment.spell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import equipment.Equipment;
import mob.Mob;

/** Spells are the player's only ranged attacks (besides special items) and consume MP on use
 */

public class Spell extends Equipment {

    protected Mob mob;
    protected int damage, cost, speed;
    protected int forwardRange, sideRange;
    protected int direction;

    protected boolean casting = false;

    public Spell(int x, int y, Context context) {
        super(x, y, context);
    }

    public void update() {
        if (!casting) return;

        switch(direction) {
            case 1: y -= speed; break;
            case 2: x += speed; y -= speed; break;
            case 3: x += speed; break;
            case 4: x += speed; y += speed; break;
            case 5: y += speed; break;
            case 6: x -= speed; y += speed; break;
            case 7: x -= speed; break;
            case 8: x -= speed; y -= speed; break;
            default: break;
        }

        if (getX() > 11 || getY() > 11 || getX() < 0 || getY() < 0) casting = false;
    }

    public void cast(int x, int y, int direction) {
        if (casting) return;

        this.x = x;
        this.y = y;
        this.direction = direction;
        casting = true;
    }

    public void attack(Mob mob) {
        mob.setHP(-damage);
        casting = false;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public void draw(Canvas c, Paint p)
    {
        if (casting) c.drawBitmap(sprite, x, y, p);
    }

    public boolean isCasting() {
        return casting;
    }
}
