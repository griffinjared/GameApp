package equipment.enemySpells;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.gameapp.gameapp.R;

import equipment.Equipment;
import mob.Mob;

/** Spells are the player's only ranged attacks (besides special items) and consume MP on use
 */

public class eSpell extends Equipment {

    protected Mob mob;

    protected int spd;
    protected int damage;
    protected int cost;
    protected boolean hit = false;

    public eSpell(int x, int y, Context context, Mob mob) {
        super(x, y, context);

        this.mob = mob;

        //Basically no sprite
        sprite = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.invisible), 1, 1, true);
    }

    public void update() {

    }

    public void damage() {
        mob.setHP(-damage);
        hit = true;
    }

    public void draw(Canvas c, Paint p) {
        if (!hit) c.drawBitmap(sprite, x, y, p);
    }

}
