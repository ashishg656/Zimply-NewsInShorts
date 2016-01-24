package shorts.zimply.com.zimplyshorts.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

/**
 * Created by Ashish Goel on 1/24/2016.
 */
public class BaseActivity extends AppCompatActivity {

    Toast toast;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void makeToast(String text) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
