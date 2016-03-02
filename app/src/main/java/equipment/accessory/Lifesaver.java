package equipment.accessory;

import android.graphics.Bitmap;

import mob.Player;

public class Lifesaver extends Accessory {

    private boolean broken = false;

    public Lifesaver(int x, int y, Player player, Bitmap spriteSheet) {
        super(x, y, player);

        name = "Lifesaver";
        sprite = Bitmap.createBitmap(spriteSheet, 0, 0, SIZE, SIZE);
    }

    public void effect() {
        if (player.getHP() == 0 && !broken) {
            player.setHP(100);
            broken = true;
        }
    }

}
