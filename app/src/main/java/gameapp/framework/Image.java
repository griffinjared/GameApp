package gameapp.framework;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface Image {
    int getWidth();
    int getHeight();
    Graphics.ImageFormat getFormat();
    void dispose();
}

