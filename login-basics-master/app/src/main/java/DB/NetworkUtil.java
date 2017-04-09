package DB;

import android.os.Build;
import android.os.StrictMode;
import android.annotation.SuppressLint;

/**
 * Created by jan on 2017-01-31.
 */
public class NetworkUtil {
    @SuppressLint("newApi")
    static public void setNetworkPolicy(){
        if(Build.VERSION.SDK_INT>9 ){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
