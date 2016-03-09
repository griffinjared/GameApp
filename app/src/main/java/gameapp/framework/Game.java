package gameapp.framework;

import android.provider.MediaStore;

import com.gameapp.gameapp.Screen;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface Game {
    MediaStore.Audio getAudio();

    Input getInput();

    //public FileIO getFileIO();

    //public Graphics getGraphics();

    void setScreen(Screen screen);

    Screen getCurrentScreen();

    Screen getInitScreen();
}
