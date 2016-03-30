package mob;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import rooms.Room;
import tiles.Tile;

/** The Mob class can be anything that moves around in the map, not just enemies.
 *  As such, the Player is a Mob as well.
 */
public class Mob {

    protected final int SIZE = Tile.SIZE;
    protected int x, y;
    protected Bitmap spriteSheet; //Image where all the sprites are stored
    protected Bitmap sprite; //Primary, currently-active sprite

    //Sprites
    protected Bitmap down;
    protected Bitmap up;
    protected Bitmap left;
    protected Bitmap right;

    //Statistics
    protected int maxHP, maxMP, baseSpeed;
    protected int hp, mp, level, speed;

    public Mob(int x, int y) {
        this.x = x*SIZE;
        this.y = y*SIZE;

        level = 1;
    }

    public void setSprites(Bitmap sprites) {
        spriteSheet = Bitmap.createScaledBitmap(sprites, 192, 24, true);

        //Set all sprites
        down = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);

        up = Bitmap.createBitmap(spriteSheet, SIZE, 0, SIZE, SIZE);

        left = Bitmap.createBitmap(spriteSheet, 2*SIZE, 0, SIZE, SIZE);

        right = Bitmap.createBitmap(spriteSheet, 3*SIZE, 0, SIZE, SIZE);

        sprite = down;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int num, Room room) {
        if (num == 1) {
            if (!collision(num, 0, room)) x += (num*SIZE);
            sprite = right;
        }
        else {
            if (!collision(num, 0, room)) x += (num*SIZE);
            sprite = left;
        }
    }
    public void setY(int num, Room room) {
        if (num == 1) {
            if (!collision(0, num, room)) y += (num*SIZE);
            sprite = down;
        }
        else {
            if (!collision(0, num, room)) y += (num*SIZE);
            sprite = up;
        }
    }

    public boolean collision(int xa, int ya, Room room) {
        try {
            if (room.getTileLayout()[(y/24)+ya][(x/24)+xa] == 0) return true;
            else if (room.getTileLayout()[(y/24)+ya][(x/24)+xa] > 4) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x, y, p);
    }

    //STAT METHODS
    public int getHP() {
        return hp;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public void setHP(int num) {
        hp += num;
        if (hp > maxHP) hp = maxHP;
        if (hp < 0) hp = 0;
    }

    public int getMP() {
        return mp;
    }
    public int getMaxMP() {
        return maxMP;
    }
    public void setMP(int num) {
        mp += num;
        if (mp > maxMP) mp = maxMP;
        if (mp < 0) mp = 0;
    }

    public int getSpeed() {
        return speed;
    }
    public int getBaseSpeed() {
        return baseSpeed;
    }
}
