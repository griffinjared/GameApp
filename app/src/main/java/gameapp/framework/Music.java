package gameapp.framework;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface Music {
    void play();
    void stop();
    void pause();
    void setLooping(boolean looping);
    void setVolume(float volume);
    boolean isPlaying();
    boolean isStopped();
    boolean isLooping();
    void dispose();
    void seekBegin();
}
