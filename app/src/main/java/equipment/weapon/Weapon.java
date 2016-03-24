package equipment.weapon;

import android.content.Context;
import android.graphics.Bitmap;

import equipment.Equipment;

/** The Player itself has no kind of damage stat
 *  Physical damage is completely decided by the weapon you're holding (and possibly an accessory as a buff)
 */

public abstract class Weapon extends Equipment {

    protected int damage;
    protected float forwardRange;
    protected float sideRange;

    public Weapon(int x, int y, Context context) {

        super(x, y, context);
    }

}
