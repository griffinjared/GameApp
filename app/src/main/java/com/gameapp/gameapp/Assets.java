package com.gameapp.gameapp;

import gameapp.framework.Image;
import gameapp.framework.Music;
import gameapp.framework.Sound;

/**
 * Created by Pierce on 3/9/2016.
 */
public class Assets {
    public static Image buttion;
    public static Sound click;
    public static Music theme;

    public static void load(Game game) {
        // TODO Auto-generated method stub
        //theme = game.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
}
