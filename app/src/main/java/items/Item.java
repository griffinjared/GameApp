package items;

import android.content.Context;
import android.graphics.Bitmap;

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

    public void setSprite(Bitmap sprite, int x, int y) {
        Bitmap spriteSheet = Bitmap.createScaledBitmap(sprite, 96, 144, true);

        this.sprite = Bitmap.createBitmap(spriteSheet, x*SIZE, y*SIZE, SIZE, SIZE);
    }

}
