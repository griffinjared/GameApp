package mob;

import java.util.Random;

import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Enemy extends Mob {

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void update(Room room) {
    }

    public void randomMovement(Room room) {
        Random random = new Random();

        int direction = random.nextInt(4);

        switch(direction) {
            //Up
            case 0: //setY(-1, room); break;

            //Right
            case 1: //setX(1, room); break;

            //Down
            case 2: //setY(1, room); break;

            //Left
            case 3: //setX(-1, room); break;
        }
    }

}
