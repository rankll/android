package adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dominio.Coisa;
import progamaro.rankll.R;
import progamaro.rankll.RankearActivity;

/**
 * Created by helio on 05/05/15.
 */
public class RecyclerRowHolder extends RecyclerView.ViewHolder {
    private Context context;
    public ImageView imagem;
    public TextView nome;
    public TextView descricao;
    public LinearLayout linearLayout;

    public RecyclerRowHolder(Context context, View itemView){
        super(itemView);
        this.context = context;
        imagem = (ImageView)itemView.findViewById(R.id.iv_item_coisa);
        nome = (TextView)itemView.findViewById(R.id.tv_item_nome_coisa);
        descricao = (TextView)itemView.findViewById(R.id.tv_item_descricao_coisa);
        linearLayout = (LinearLayout)itemView.findViewById(R.id.ll_item_coisa);
    }
}
