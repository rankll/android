package progamaro.rankll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dominio.Coisa;

/**
 * Created by helio on 08/05/15.
 */
public class MainActivityDetalhes extends Activity {

    private Coisa coisa;
    private EditText edtCoisaNome;
    private EditText edtCoisaDescricao;
    private Button btnAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalhes);

        this.edtCoisaDescricao = (EditText) findViewById(R.id.edtEdicaoCoisaDescricao);
        this.edtCoisaNome = (EditText) findViewById(R.id.edtEdicaoCoisaNome);
        this.btnAlterar = (Button) findViewById(R.id.btnAlterarCoisa);

        this.coisa = (Coisa) getIntent().getExtras().get("Coisa");
        this.edtCoisaNome.setText(coisa.getNome());
        this.edtCoisaDescricao.setText(coisa.getDescricao());

        this.btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivityDetalhes.this, "TO DO", Toast.LENGTH_LONG).show();
            }
        });
    }
}
