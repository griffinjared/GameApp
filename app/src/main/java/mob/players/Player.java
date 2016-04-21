package mob.players;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

import equipment.spell.Spell;
import items.Item;
import mob.Enemy;
import mob.Mob;
import rooms.Room;

/** The real purpose of the Player class is to provide a sprite and controls
 */

public class Player extends Mob {

    /** 1 2 3
     *  4   5
     *  6 7 8
     */

    private int roomX, roomY; //coordinates in the level layout grid
    protected Spell spell;
    protected Item item;

    public Player(int x, int y) {
        super(x, y);
    }

    public int update(Room room) {
        spell.update();
        spellCollision(room);

        if (x <= -SIZE) { //West
            x = (SIZE*12) - SIZE;
            return 4;
        }
        else if (x >= SIZE*12) { //East
            x = 0;
            return 2;
        }
        else if (y <= -SIZE) { //North
            y = (SIZE*12) - SIZE;
            return 1;
        }
        else if (y >= SIZE*12) { //East
            y = 0;
            return 3;
        }

        return 0;
    }

    public void setLevelPosition(int x, int y) {
        roomX = x;
        roomY = y;
    }

    public void objectCollision(int xa, int ya, Room room) {
        //Detect enemies
        ArrayList<Enemy> enemies = room.getEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);

            if (e.getX() - xa == getX() && e.getY() - ya == getY()) {
                attack(xa, ya, e);
            }
        }

        //Detect items
        ArrayList<Item> items = room.getItems();
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);

            if (it.getX() == getX() && it.getY() == getY()) {
                if (item != null) {
                    item = it;
                    room.takeItem(it, item);
                }
                else
                {
                    item = it;
                    room.takeItem(it, null);
                }

                item.setActive();
            }
        }
    }

    public void spellCollision(Room room) {
        ArrayList<Enemy> enemies = room.getEnemies();

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);

            if (spell.getX() == e.getX() && spell.getY() == e.getY()) {
                spell.attack(e);
            }
        }
    }

    public void attack(int xa, int ya, Enemy e) {
        e.setHP(-pwr);
        attackSprites(xa, ya);
    }

    public void attackSprites(int xa, int ya) {
        if (ya == -1) sprite = atk_up;
        else if (ya == 1) sprite = atk_down;
        else if (xa == -1) sprite = atk_right;
        else if (xa == 1) sprite = atk_left;
    }

    public void magicAttackSprites() {
        if (sprite == up) sprite = atk_up;
        else if (sprite == down) sprite = atk_down;
        else if (sprite == right) sprite = atk_right;
        else if (sprite == left) sprite = atk_left;
    }

    public void magic(int direction) {
        if (mp < spell.getCost() || spell.isCasting()) return;

        spell.cast(x, y, direction);
        setMP(-spell.getCost());
        magicAttackSprites();
    }

    //Movement
    @Override
    public void setX(int num, Room room) {
        super.setX(num, room);
        objectCollision(num, 0, room);
    }

    @Override
    public void setY(int num, Room room) {
        super.setY(num, room);
        objectCollision(0, num, room);
    }

    @Override
    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
        spell.draw(c, p);
        if (item != null) item.draw(c, p);
    }

    //Items and Equipment
    public Item getItem() {
        return item;
    }

    public void setItem(Item it) {
        item = it;
    }
}
