package com.gameapp.gameapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    private Graphics graphics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        graphics = new Graphics(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(graphics);
    }

    @Override
    public void onBackPressed() {
        graphics.pauseEquip();
        //super.onBackPressed(); //default behavior, remove if changed
        return;
    }

    public void sendMessage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
