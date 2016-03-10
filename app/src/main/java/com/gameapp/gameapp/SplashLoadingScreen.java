package com.gameapp.gameapp;

import gameapp.framework.Game;
import gameapp.framework.Graphics;

/**
 * Created by Pierce on 3/9/2016.
 */
public class SplashLoadingScreen extends gameapp.framework.Screen {
    public SplashLoadingScreen(com.gameapp.gameapp.Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        //Assets.splash = g.newImage("splash.jpg", Graphics.ImageFormat.RGB565);


        game.setScreen(new LoadingScreen(game));

    }

    @Override
    public void paint(float deltaTime) {

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
