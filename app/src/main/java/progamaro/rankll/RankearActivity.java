package progamaro.rankll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import dominio.Coisa;

/**
 * Created by andremiranda on 08/05/15.
 */
public class RankearActivity extends Activity {
    private Coisa coisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rank_rankear);

        Intent it = getIntent();
        coisa = (Coisa) it.getExtras().get("Coisa");
        Toast.makeText(this, coisa.getDescricao(), Toast.LENGTH_SHORT ).show();

    }
}
