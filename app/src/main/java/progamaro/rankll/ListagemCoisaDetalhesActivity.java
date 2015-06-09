package progamaro.rankll;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
 * Created by helio on 08/05/15.
 */
public class ListagemCoisaDetalhesActivity extends Activity {

    private Coisa coisa;
    private EditText edtCoisaNome;
    private EditText edtCoisaDescricao;
    private Button btnAlterar;
    private ImageView imgCoisa;
    private int TAKE_PHOTO_CODE = 0;
    private int CHOOSE_PHOTO = 1;
    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_detalhes);

        this.imgCoisa = (ImageView)findViewById(R.id.iv_coisa_detalhes_imagem);
        this.edtCoisaDescricao = (EditText) findViewById(R.id.edtEdicaoCoisaDescricao);
        this.edtCoisaNome = (EditText) findViewById(R.id.edtEdicaoCoisaNome);
        this.btnAlterar = (Button) findViewById(R.id.btnAlterarCoisa);

        this.coisa = (Coisa) getIntent().getExtras().get("Coisa");

        if (coisa.getId().equals("5")) {
            imgCoisa.setImageResource(R.mipmap.logo_294);
        }

        this.edtCoisaNome.setText(coisa.getName());
        this.edtCoisaDescricao.setText(coisa.getDescription());

        registerForContextMenu(imgCoisa);
/*        imgCoisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });*/

        this.btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(ListagemCoisaDetalhesActivity.this);
                //Toast.makeText(ListagemCoisaDetalhesActivity.this, "TO DO", Toast.LENGTH_LONG).show();
            }
        });
    }

    public Dialog createDialog(Context mContext) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setTitle("Informação");
        builder.setMessage("Deseja alterar Coisa?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        coisa.setName(edtCoisaNome.getText().toString());
                        coisa.setDescription(edtCoisaDescricao.getText().toString());
                        Intent it = new Intent();
                        it.putExtra("objCoisa", coisa);
                        setResult(0, it);
                        finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
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
