package gameapp.framework;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface Audio {
    Music createMusic(String file);
    Sound createSound(String file);
}
