package gameapp.framework;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface Game {
    Audio getAudio();

    Input getInput();

    FileIO getFileIO();

    Graphics getGraphics();

    void setScreen(Screen screen);

    Screen getCurrentScreen();

    Screen getInitScreen();
}
