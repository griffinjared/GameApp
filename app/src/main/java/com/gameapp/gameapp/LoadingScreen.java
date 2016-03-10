package com.gameapp.gameapp;

//import gameapp.framework.Game;
//import gameapp.framework.Graphics;
import gameapp.framework.Screen;

/**
 * Created by Pierce on 3/9/2016.
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        //Graphics g = game.getGraphics();
        //This is how you would load a sound if you had one.
        //Assets.click = game.getAudio().createSound("explode.ogg");

        //game.setScreen(new com.gameapp.gameapp.Screen(game));

    }

    @Override
    public void paint(float deltaTime) {
        //Graphics g = game.getGraphics();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}
