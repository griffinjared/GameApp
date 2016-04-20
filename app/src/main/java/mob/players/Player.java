package mob.players;

import java.util.ArrayList;

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

    public Player(int x, int y) {
        super(x, y);
    }

    public int update() {
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

    public void enemyCollision(int xa, int ya, Room room) {
        //Detect enemies
        ArrayList<Enemy> enemies = room.getEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);

            if (e.getX() - xa == getX() && e.getY() - ya == getY()) {
                attack(xa, ya, e);
            }
        }
    }

    public void attack(int xa, int ya, Enemy e) {
        e.setHP(-pwr);

        if (ya == -1) sprite = atk_up;
        else if (ya == 1) sprite = atk_down;
        else if (xa == -1) sprite = atk_right;
        else if (xa == 1) sprite = atk_left;
    }

    //Movement
    @Override
    public void setX(int num, Room room) {
        super.setX(num, room);
        enemyCollision(num, 0, room);
    }

    @Override
    public void setY(int num, Room room) {
        super.setY(num, room);
        enemyCollision(0, num, room);
    }
}
