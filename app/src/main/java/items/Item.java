package items;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import mob.players.Player;
import tiles.Tile;

public class Item {

    protected int x, y;
    protected Bitmap sprite;
    protected final int SIZE = Tile.SIZE;
    protected Player player;
    protected String name;
    protected Context context;

    public Item(int x, int y, Player player, Context context) {
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.player = player;
        this.context = context;
    }

    public void effect() {

    }

    public void setActive() {
        x = 2 * SIZE;
        y = 0;
    }

    public void setSprite(Bitmap sprite, int x, int y) {
        System.gc();
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprite, 96, 96, true);

        this.sprite = Bitmap.createBitmap(spriteSheet, x*SIZE, y*SIZE, SIZE, SIZE);
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(sprite, x, y, p);
    }

    public int getX() {
        return x / SIZE;
    }
    public int getY() {
        return y / SIZE;
    }

}
