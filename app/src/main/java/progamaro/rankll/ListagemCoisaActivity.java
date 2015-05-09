package progamaro.rankll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;
import dominio.Coisa;


public class ListagemCoisaActivity extends Activity {

    // Criar uma lista de Ranks
    List<Coisa> items = new ArrayList<Coisa>();
    private RecyclerView rvCoisa;
    private RecyclerAdapter adapter;
    private final int REQUEST_CODE_COISA = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_listagem);

        criar_popular();
        setLayout();
        adapter = new RecyclerAdapter(this, items);
        rvCoisa.setAdapter(adapter);
        rvCoisa.setItemAnimator(new DefaultItemAnimator());
        rvCoisa.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setLayout(){
        rvCoisa = (RecyclerView) findViewById(R.id.rv_coisa);
    }

    public void criar_popular(){
        items = new ArrayList<Coisa>();

        for(int i=0; i<5; i++){
            items.add(new Coisa(i, "Grécio Beline "+i, "descricaogrecio "+i));
            items.add(new Coisa(i, "André Miranda " + i, "descricaoandre "+i));
            items.add(new Coisa(i, "Hélio Feliciano " + i, "descricaohelio "+i));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.action_add_coisa){
            Intent it = new Intent(ListagemCoisaActivity.this, CadastroCoisaActivity.class);
            startActivityForResult(it, REQUEST_CODE_COISA);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == REQUEST_CODE_COISA){
            Coisa _coisa = (Coisa)data.getSerializableExtra("objCoisa");
            items.add(_coisa);
            adapter.notifyDataSetChanged();

            Toast.makeText(ListagemCoisaActivity.this, _coisa.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
