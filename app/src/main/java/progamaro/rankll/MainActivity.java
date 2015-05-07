package progamaro.rankll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;
import dominio.Coisa;
import dominio.Rank;


public class MainActivity extends Activity {

    // Criar uma lista de Ranks
    List<Coisa> items = new ArrayList<Coisa>();
    private RecyclerView recyclerView;
    //private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criar_popular();
        setLayout();
        RecyclerAdapter usuAdapter = new RecyclerAdapter(this, items);
        recyclerView.setAdapter(usuAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setClickable(true);
    }

    private void setLayout(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    public void criar_popular(){
        items = new ArrayList<Coisa>();

        for(int i=0; i<100; i++){
            items.add(new Coisa(i, "Grécio Miranda "+i, ""));
            items.add(new Coisa(i, "André Miranda" + i, ""));
            items.add(new Coisa(i, "Hélio Feliciano" + i, ""));
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
            Intent it = new Intent(MainActivity.this, CadastroCoisaActivity.class);
            startActivity(it);
        }

        return super.onOptionsItemSelected(item);
    }
}
