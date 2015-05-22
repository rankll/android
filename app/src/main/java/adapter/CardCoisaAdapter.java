package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dominio.Coisa;
import progamaro.rankll.ListagemCoisaActivity;
import progamaro.rankll.R;

/**
 * Created by andremiranda on 21/05/15.
 */
public class CardCoisaAdapter extends RecyclerView.Adapter<CardCoisaAdapter.ViewHolder> {

    private Context context;
    private List<Coisa> items;

    public CardCoisaAdapter(Context context, List<Coisa> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public CardCoisaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_coisa, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(CardCoisaAdapter.ViewHolder holder, int position) {
        final Coisa coisa = items.get(position);
        holder.tv_item_nome_coisa.setText(coisa.getNome());
        holder.tv_item_nome_coisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "teste", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_item_nome_coisa;

        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            tv_item_nome_coisa = (TextView)itemView.findViewById(R.id.tv_item_nome_coisa);


        }
    }
}
