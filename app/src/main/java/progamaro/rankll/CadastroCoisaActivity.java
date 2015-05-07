package progamaro.rankll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dominio.Coisa;

/**
 * Created by andremiranda on 06/05/15.
 */
public class CadastroCoisaActivity extends Activity {

    private EditText edtCadastroCoisaNome;
    private EditText edtCadastroCoisaDescricao;
    private EditText edtCadastroCoisaTag;
    private Button btnCadastroCoisa;
    private List<String> tags;
    private Coisa _coisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_cadastro);

        edtCadastroCoisaNome = (EditText) findViewById(R.id.edtCadastroCoisaNome);
        edtCadastroCoisaDescricao = (EditText) findViewById(R.id.edtCadastroCoisaDescricao);
        edtCadastroCoisaTag = (EditText) findViewById(R.id.edtCadastroCoisaTags);
        btnCadastroCoisa = (Button) findViewById(R.id.btnCadastroCoisa);
        tags = new ArrayList<String>();

        btnCadastroCoisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _coisa = new Coisa();
                _coisa.setDescricao(edtCadastroCoisaDescricao.getText().toString());
                _coisa.setNome(edtCadastroCoisaNome.getText().toString());

                tags.add(edtCadastroCoisaTag.getText().toString());
                _coisa.setTags(tags);

                Toast.makeText(CadastroCoisaActivity.this, _coisa.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
