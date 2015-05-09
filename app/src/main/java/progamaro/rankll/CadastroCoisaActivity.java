package progamaro.rankll;

import android.app.Activity;
import android.content.Intent;
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

        edtCadastroCoisaNome = (EditText) findViewById(R.id.et_cadastro_coisa_nome);
        edtCadastroCoisaDescricao = (EditText) findViewById(R.id.et_cadastro_coisa_descricao);
        btnCadastroCoisa = (Button) findViewById(R.id.btn_cadastro_coisa);

        btnCadastroCoisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _coisa = new Coisa();
                _coisa.setDescricao(edtCadastroCoisaDescricao.getText().toString());
                _coisa.setNome(edtCadastroCoisaNome.getText().toString());

                Intent it = new Intent();
                it.putExtra("objCoisa", _coisa);
                setResult(0, it);
                finish();

                //Toast.makeText(CadastroCoisaActivity.this, _coisa.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
