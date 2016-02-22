package com.gameapp.gameapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

/** The MainActivity class is the starting screen of the game.
 *  It doesn't do much and is a simple menu.
 *  All it has are a few buttons that lead to other parts of the app.
 *  For example, the New Game button (visible on the "content_main.xml" file) leads to the Game Activity
 *  Right now, only the New Game button works
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set to full-screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Turn off app tittle
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        final SeedGenerator seeder = new SeedGenerator();
    }

    //Start Game
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
