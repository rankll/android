package progamaro.rankll;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

import dominio.Coisa;

/**
 * Created by andremiranda on 06/05/15.
 */
public class CadastroCoisaActivity extends Activity {


    private EditText edtCadastroCoisaNome;
    private EditText edtCadastroCoisaDescricao;
    private Button btnCadastroCoisa;
    private Coisa _coisa;
    private ImageView imgCoisa;
    private int TAKE_PHOTO_CODE = 0;
    private int CHOOSE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_cadastro);

        this.imgCoisa = (ImageView)findViewById(R.id.iv_coisa_detalhes_imagem);
        edtCadastroCoisaNome = (EditText) findViewById(R.id.et_cadastro_coisa_nome);
        edtCadastroCoisaDescricao = (EditText) findViewById(R.id.et_cadastro_coisa_descricao);
        btnCadastroCoisa = (Button) findViewById(R.id.btn_cadastro_coisa);

        btnCadastroCoisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _coisa = new Coisa();
                _coisa.setDescription(edtCadastroCoisaDescricao.getText().toString());
                _coisa.setName(edtCadastroCoisaNome.getText().toString());

                Intent it = new Intent();
                it.putExtra("objCoisa", _coisa);
                setResult(1, it);
                finish();

                //Toast.makeText(CadastroCoisaActivity.this, _coisa.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, v.getId(), 0, "Escolher uma foto");
        menu.add(0, v.getId(), 0, "Tirar uma foto");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("Tirar uma foto")){
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
        } else if(item.getTitle().equals("Escolher uma foto")){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CHOOSE_PHOTO);
        } else {
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_PHOTO_CODE) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgCoisa.setImageBitmap(photo);
            }

            if (requestCode == CHOOSE_PHOTO) {

                try {
                    InputStream imageStream = getContentResolver().openInputStream(data.getData());
                    Bitmap photo = BitmapFactory.decodeStream(imageStream);
                    imgCoisa.setImageBitmap(photo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
