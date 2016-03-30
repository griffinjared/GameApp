package mob;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Enemy extends Mob {

    protected long timer = 0;

    public Enemy(int x, int y) {
        super(x, y);

        timer = System.currentTimeMillis();
    }

    public void update(Room room) {
    }

    @Override
    public void setX(int num, Room room) {
        super.setX(num, room);

        if (x + num == 0 || x + num == 11) return;
    }

    @Override
    public void setY(int num, Room room) {
        super.setY(num, room);

        if (y + num == 0 || y + num == 11) return;
    }

    public void randomMovement(Room room) {
        Random random = new Random();

        int direction = random.nextInt(4);

        switch(direction) {
            //Up
            case 0: setY(-1, room); break;

            //Right
            case 1: setX(1, room); break;

            //Down
            case 2: setY(1, room); break;

            //Left
            case 3: setX(-1, room); break;
        }
    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
    }

}
