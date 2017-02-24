package example.test.com.wikiimagesearch.ui.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import example.test.com.wikiimagesearch.R;

/**
 * Created by root on 23/2/17.
 */
public class ActBase extends AppCompatActivity {

    protected void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
