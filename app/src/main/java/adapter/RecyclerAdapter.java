package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import dominio.Coisa;
import progamaro.rankll.ListagemCoisaActivity;
import progamaro.rankll.ListagemCoisaDetalhesActivity;
import progamaro.rankll.R;
import progamaro.rankll.RankearActivity;

/**
 * Created by helio on 04/05/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerRowHolder> {

    private Context context;
    private List<Coisa> items;
    private int lastPosition = -1;

    public RecyclerAdapter(Context context, List<Coisa> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.coisa_listagem_item, parent, false);

        return new RecyclerRowHolder(context, view);
    }


    @Override
    public void onBindViewHolder(RecyclerRowHolder holder, final int position) {

        final Coisa coisa = items.get(position);
        //holder.imagem.setImageDrawable(Resources.getSystem().getDrawable(R.mipmap.ic_launcher));
        holder.nome.setText(coisa.getNome());
        holder.descricao.setText(coisa.getDescricao());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, ListagemCoisaDetalhesActivity.class);
                it.putExtra("Coisa", coisa);
                //startActivityForResult();
                context.startActivity(it);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent it = new Intent(context, RankearActivity.class);
                it.putExtra("Coisa", coisa);
                context.startActivity(it);
                return true;
            }
        });

        setAnimation(holder.linearLayout, position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
