package progamaro.rankll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dominio.Coisa;

/**
 * Created by andremiranda on 06/05/15.
 */
public class CadastroCoisaActivity extends Activity {

    private EditText edtCadastroCoisaNome;
    private EditText edtCadastroCoisaDescricao;
    private Button btnCadastroCoisa;
    private Coisa _coisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_cadastro);

        edtCadastroCoisaNome = (EditText) findViewById(R.id.edtCadastroCoisaNome);
        edtCadastroCoisaDescricao = (EditText) findViewById(R.id.edtCadastroCoisaDescricao);
        btnCadastroCoisa = (Button) findViewById(R.id.btnCadastroCoisa);

        btnCadastroCoisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _coisa = new Coisa();
                _coisa.setDescricao(edtCadastroCoisaDescricao.getText().toString());
                _coisa.setNome(edtCadastroCoisaNome.getText().toString());

                Toast.makeText(CadastroCoisaActivity.this, _coisa.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
