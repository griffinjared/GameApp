package com.gameapp.gameapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/** Despite its name, the Game class doesn't do much
 *  Instead, it is just the Activity for the Game's starting processes
 *  Just like how the MainActivity brings up the menu and doesn't do much else, this class starts up the game and then waits for it be over
 */

public class Game extends Activity {

    private static final String TAG = Game.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requesting to turn title OFF
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // full-screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Content View
        setContentView(new Screen(this));
        Log.d(TAG, "View added");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Destroying...");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Stopping...");
        super.onStop();
    }

}
