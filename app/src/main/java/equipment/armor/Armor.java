package equipment.armor;

import android.content.Context;

import equipment.Equipment;

/** Armors defend against some percentage of physical damage, magical, damage, and sometimes both
 */

public abstract class Armor extends Equipment {

    protected float physicalBuffer;
    protected float magicalBuffer;

    public Armor(int x, int y, Context context) {
        super(x, y, context);
    }

}
