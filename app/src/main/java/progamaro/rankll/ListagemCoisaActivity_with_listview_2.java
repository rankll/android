package progamaro.rankll;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.CoisaAdapter;
import dominio.Coisa;


public class ListagemCoisaActivity_with_listview_2 extends Activity {

    // Criar uma lista de Ranks
    List<Coisa> items = new ArrayList<Coisa>();
    private ListView lvCoisa;
    private GridView gvCoisa;
    private final int REQUEST_UPDATE_COISA = 0;
    private final int REQUEST_INSERT_COISA = 1;
    private CoisaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_listagem_with_listview);

        //criar_popular();
        adapter = new CoisaAdapter(this, items);
        lvCoisa = (ListView)findViewById(R.id.lv_coisa);
        gvCoisa = (GridView)findViewById(R.id.gv_coisa);
        lvCoisa.setAdapter(adapter);
        gvCoisa.setAdapter(adapter);

        lvCoisa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Coisa item = (Coisa) parent.getItemAtPosition(position);
                item.setPosition(position);


                Intent it = new Intent(ListagemCoisaActivity_with_listview_2.this, ListagemCoisaDetalhesActivity.class);
                it.putExtra("Coisa", item);
                startActivityForResult(it, REQUEST_UPDATE_COISA);
            }
        });

    }

    public void criar_popular(){
        items = new ArrayList<Coisa>();

        for(int i=0; i<5; i++){
            items.add(new Coisa(i+"", "Grécio Beline "+i, "descricaogrecio "+i));
            items.add(new Coisa(i+"", "André Miranda " + i, "descricaoandre "+i));
            items.add(new Coisa(i+"", "Hélio Feliciano " + i, "descricaohelio "+i));
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
            Intent it = new Intent(ListagemCoisaActivity_with_listview_2.this, CadastroCoisaActivity.class);
            startActivityForResult(it, REQUEST_INSERT_COISA);
        } else if(id == R.id.action_notification){
            EnviarNotificacao();
        }

        return super.onOptionsItemSelected(item);
    }

    private void EnviarNotificacao() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Nova notificação")
                        .setContentText("Olá, seja bem vindo ao Rankll!");

        Intent resultIntent = new Intent(this, ListagemCoisaActivity_with_listview_2.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(RankearActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Coisa _coisa = null;
        if (data!=null){
            _coisa = (Coisa) data.getSerializableExtra("objCoisa");

            if (requestCode == REQUEST_INSERT_COISA) {
                //_coisa = (Coisa) data.getSerializableExtra("objCoisa");
                items.add(_coisa);
                adapter.notifyDataSetChanged();
            } else if (requestCode == REQUEST_UPDATE_COISA) {
                //_coisa = (Coisa) data.getSerializableExtra("objCoisa");

                for (Coisa item : items) {
                    if (item.getPosition() == _coisa.getPosition()) {
                        item.setDescription(_coisa.getDescription());
                        item.setName(_coisa.getName());
                    }
                }

                //items.add(_coisa);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
