package levels;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by griff on 3/23/2016.
 */
public class Level_3_Underwater extends Level {

    public Level_3_Underwater(Context context, Bitmap spriteSheet) {
        super(context);
        changeTilesSprites(spriteSheet);
    }
}
