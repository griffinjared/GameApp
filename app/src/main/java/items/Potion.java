package items;

import android.graphics.Bitmap;

import mob.Player;

public class Potion extends Item {

    public Potion(int x, int y, Player player, Bitmap spriteSheet) {
        super(x, y, player);

        name = "Poton";
        sprite = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
    }

    public void effect() {
        player.setHP(150);
    }

}
