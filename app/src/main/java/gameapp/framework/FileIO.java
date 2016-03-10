package gameapp.framework;

import android.content.SharedPreferences;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Pierce on 3/9/2016.
 */
public interface FileIO {
    InputStream readFile(String file) throws IOException;
    OutputStream writeFile(String file) throws IOException;
    InputStream readAsset(String file) throws IOException;
    SharedPreferences getSharedPref();
}
