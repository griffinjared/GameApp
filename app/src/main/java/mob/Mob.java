package mob;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.Graphics;
import com.gameapp.gameapp.R;

import levels.Level;
import levels.Level_2_Caves;
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
    protected Bitmap down, up, left, right;
    protected Bitmap atk_down, atk_up, atk_left, atk_right;
    protected Bitmap hit;

    //Statistics
    protected int maxHP, maxMP, baseSpeed;
    protected int hp, mp, level, speed;

    public Mob(int x, int y) {
        this.x = x*SIZE;
        this.y = y*SIZE;

        level = 1;
    }

    public void setSprites(Bitmap sprites) {
        spriteSheet = Bitmap.createScaledBitmap(sprites, 216, 24, true);

        //Set all sprites
        down = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
        up = Bitmap.createBitmap(spriteSheet, SIZE, 0, SIZE, SIZE);
        left = Bitmap.createBitmap(spriteSheet, 2*SIZE, 0, SIZE, SIZE);
        right = Bitmap.createBitmap(spriteSheet, 3 * SIZE, 0, SIZE, SIZE);

        atk_down = Bitmap.createBitmap(spriteSheet, 4*SIZE, 0, SIZE, SIZE);
        atk_up = Bitmap.createBitmap(spriteSheet, 5*SIZE, 0, SIZE, SIZE);
        atk_left = Bitmap.createBitmap(spriteSheet, 6*SIZE, 0, SIZE, SIZE);
        atk_right = Bitmap.createBitmap(spriteSheet, 7*SIZE, 0, SIZE, SIZE);

        hit = Bitmap.createBitmap(spriteSheet, 8*SIZE, 0, SIZE, SIZE);

        sprite = down;
    }

    public int getX() {
        return x/24;
    }
    public int getY() {
        return y/24;
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

    public boolean goingToNextLevel(int xa, int ya, Room room) {
        try {
            if(room.getTileLayout()[(y/24)+ya][(x/24)+xa] == 9) {
                return true;
            }
            return false;

        }
        catch (Exception e) {
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
