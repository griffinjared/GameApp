package com.gameapp.gameapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import gameapp.framework.Screen;
import gameapp.framework.implementation.AndroidAudio;
import gameapp.framework.implementation.AndroidFastRenderView;
import gameapp.framework.implementation.AndroidFileIO;
import gameapp.framework.implementation.AndroidGame;
import gameapp.framework.implementation.AndroidGraphics;
import gameapp.framework.implementation.AndroidInput;

/** Despite its name, the Game class doesn't do much
 *  Instead, it is just the Activity for the Game's starting processes
 *  Just like how the MainActivity brings up the menu and doesn't do much else, this class starts up the game and then waits for it be over
 */

public class Game extends Activity {

    private static final String TAG = gameapp.framework.Game.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new Graphics(this));
    }

    /*
    public static String map;
    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {

        if (firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        //InputStream is = getResources().openRawResource(R.raw.map1);
        //map = convertStreamToString(is);

        return new SplashLoadingScreen(this);

    }

    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            Log.w("LOG", e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.w("LOG", e.getMessage());
            }
        }
        return sb.toString();
    }

    @Override
    public void onResume() {
        super.onResume();

        Assets.theme.play();

    }

    @Override
    public void onPause() {
        super.onPause();
        Assets.theme.pause();

    }
    */
}
