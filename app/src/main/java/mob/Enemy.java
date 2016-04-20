package mob;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

import mob.players.Player;
import rooms.Room;

/**
 * Created by Andrew on 3/23/2016.
 */
public class Enemy extends Mob {

    protected long timer = 0;
    protected Player player;

    public Enemy(int x, int y, Player player) {
        super(x, y);

        this.player = player;
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
        if (attack()) {
            attackSprite();
            return;
        }

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

    public void chaserMovement(Room room) {
        if (attack()) {
            attackSprite();
            return;
        }

        //Follow Player
        if (player.getX() < getX()) setX(-1, room);
        else if (player.getX() > getX()) setX(1, room);

        if (player.getY() < getY()) setY(-1, room);
        else if (player.getY() > getY()) setY(1, room);
    }

    public boolean attack() {
        if (Math.abs(player.getX() - getX()) <= 1 && Math.abs(player.getY() - getY()) <= 1) {
            player.setHP(-pwr);
            return true;
        }

        return false;
    }

    public void draw(Canvas c, Paint p) {
        super.draw(c, p);
    }

    public void attackSprite() {
        int direction = 0;

        //UP and RIGHT
        if (player.getX() > getX() && player.getY() < getY()) direction = 2;

        //DOWN and RIGHT
        else if (player.getX() > getX() && player.getY() > getY()) direction = 4;

        //DOWN and LEFT
        else if (player.getX() < getX() && player.getY() > getY()) direction = 6;

        //UP and LEFT
        else if (player.getX() < getX() && player.getY() < getY()) direction = 8;

        //Straight UP
        else if (player.getX() == getX() && player.getY() < getY()) direction = 1;

        //Straight RIGHT
        else if (player.getX() > getX() && player.getY() == getY()) direction = 3;

        //Straight DOWN
        else if (player.getX() == getX() && player.getY() > getY()) direction = 5;

        //Straight LEFT
        else if (player.getX() < getX() && player.getY() == getY()) direction = 7;

        switch(direction) {
            case 1: sprite = atk_up; break;
            case 2:case 3:case 4: sprite = atk_right; break;
            case 5: sprite = atk_down; break;
            case 6:case 7:case 8: sprite = atk_left;
        }
    }
}
