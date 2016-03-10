package gameapp.framework.implementation;

import android.view.View;

import java.util.List;

import gameapp.framework.Input;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface TouchHandler extends View.OnTouchListener {
    boolean isTouchDown(int pointer);

    int getTouchX(int pointer);

    int getTouchY(int pointer);

    List<Input.TouchEvent> getTouchEvents();
}
