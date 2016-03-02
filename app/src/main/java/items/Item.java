package items;

import android.graphics.Bitmap;

import mob.Player;
import tiles.Tile;

public class Item {

    protected int x, y;
    protected Bitmap sprite;
    protected final int SIZE = Tile.SIZE;
    protected Player player;
    protected String name;

    public Item(int x, int y, Player player) {
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.player = player;
    }

    public void effect() {

    }

}
