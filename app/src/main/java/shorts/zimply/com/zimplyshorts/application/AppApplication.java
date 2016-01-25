package shorts.zimply.com.zimplyshorts.application;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Application class for the app
 *
 * @author ashish
 */
public class AppApplication extends Application {

    public static AppApplication sInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        mRequestQueue = getRequestQueue();
    }

    public static AppApplication getInstance() {
        if (sInstance == null)
            sInstance = new AppApplication();
        return sInstance;
    }

    public static String getBaseUrl() {
        return "http://104.131.92.67/";
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getInstance().getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}