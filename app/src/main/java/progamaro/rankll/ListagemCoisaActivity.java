package progamaro.rankll;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CardCoisaAdapter;
//import data.DataThings;
import dominio.Coisa;


public class ListagemCoisaActivity extends Activity {

    // Criar uma lista de Ranks
    List<Coisa> items = new ArrayList<Coisa>();
    private RecyclerView rvCoisa;
    private CardCoisaAdapter adapter;
    private final int REQUEST_CODE_COISA = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coisa_listagem);

        //DataThings data = new DataThings();
        //data.getYourThings(this);

        criar_popular();
        setLayout();
        rvCoisa.setAdapter(new CardCoisaAdapter(this, items));
        rvCoisa.setItemAnimator(new DefaultItemAnimator());
        rvCoisa.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setLayout(){
        rvCoisa = (RecyclerView) findViewById(R.id.rv_coisa);
    }

    public void criar_popular(){
        items = new ArrayList<Coisa>();

        for(int i=0; i<5; i++){
            items.add(new Coisa(i+"", "Restaurante", "bla bla bla bla jdklasjdlkjas dsajd jasldksa"));
            items.add(new Coisa(i+"", "Praia", "blo blo blo blo blo blo dashdjksadsa dashdhakd"));
            items.add(new Coisa(i+"", "Bairro", "blu blu blu bdkjaskdljalsdjsajd  djasdkas dkajdjadl lskdja"));
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

        Intent resultIntent = new Intent(this, ListagemCoisaActivity.class);
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

        if (resultCode == REQUEST_CODE_COISA){
            Coisa _coisa = (Coisa)data.getSerializableExtra("objCoisa");
            items.add(_coisa);
            adapter.notifyDataSetChanged();

            Toast.makeText(ListagemCoisaActivity.this, _coisa.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
