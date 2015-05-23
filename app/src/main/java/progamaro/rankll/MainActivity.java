package progamaro.rankll;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;


/**
 * Created by helio on 21/05/15.
 */
public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

    }


}
