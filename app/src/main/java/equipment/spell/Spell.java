package equipment.spell;

import equipment.Equipment;

/** Spells are the player's only ranged attacks (besides special items) and consume MP on use
 */

public class Spell extends Equipment {

    protected int damage;
    protected int cost;
    protected int forwardRange;
    protected int sideRange;

    public Spell(int x, int y) {
        super(x, y);
    }

}
