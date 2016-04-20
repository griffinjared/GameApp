package equipment.enemySpells;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

import mob.Mob;
import tiles.Tile;

/** Starting spell for the Mage player class */

public class eMagArrow extends eSpell {

    private int direction = 1;

    public eMagArrow(int x, int y, Context context, Mob mob, int mag) {
        super(x, y, context, mob);

        name = "Magic Arrow";
        damage = 1 * mag;
        cost = 1;
        spd = 3;

        setSprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.spells), 0, 0);

        //Set direction

        //UP and RIGHT
        if (mob.getX() > getX() && mob.getY() < getY()) direction = 2;

        //DOWN and RIGHT
        else if (mob.getX() > getX() && mob.getY() > getY()) direction = 4;

        //DOWN and LEFT
        else if (mob.getX() < getX() && mob.getY() > getY()) direction = 6;

        //UP and LEFT
        else if (mob.getX() < getX() && mob.getY() < getY()) direction = 8;

        //Straight UP
        else if (mob.getX() == getX() && mob.getY() < getY()) direction = 1;

        //Straight RIGHT
        else if (mob.getX() > getX() && mob.getY() == getY()) direction = 3;

        //Straight DOWN
        else if (mob.getX() == getX() && mob.getY() > getY()) direction = 5;

        //Straight LEFT
        else if (mob.getX() < getX() && mob.getY() == getY()) direction = 7;
    }

    @Override
    public void update() {
        switch(direction) {
            case 1: y--; break;
            case 2: x++; y--; break;
            case 3: x++; break;
            case 4: x++; y++; break;
            case 5: y++; break;
            case 6: x--; y++; break;
            case 7: x--; break;
            case 8: x--; y--; break;
        }

        if (Math.abs(getX() - mob.getX()) <= 0 && Math.abs(getY() - mob.getY()) <= 0) {
            if (!hit) damage();
        }
    }

}
