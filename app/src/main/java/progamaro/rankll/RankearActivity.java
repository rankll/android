package progamaro.rankll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import dominio.Coisa;
import dominio.Rank;

/**
 * Created by andremiranda on 08/05/15.
 */
public class RankearActivity extends Activity {
    private Coisa coisa;
    private Rank rank;
    private RatingBar rb_rating;
    private TextView tv_rankear_coisa_nome;
    private EditText et_rankear_comentario;
    private Button btnRankear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rank_rankear);

        Intent it = getIntent();
        coisa = (Coisa) it.getExtras().get("Coisa");

        rb_rating = (RatingBar) findViewById(R.id.rb_rating);
        et_rankear_comentario = (EditText) findViewById(R.id.et_rankear_comentario);
        tv_rankear_coisa_nome = (TextView) findViewById(R.id.tv_rankear_coisa_nome);
        tv_rankear_coisa_nome.setText(coisa.getNome());
        btnRankear = (Button) findViewById(R.id.btnRankear);

        btnRankear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rank = new Rank();


                Toast.makeText(RankearActivity.this, String.valueOf(rb_rating.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
