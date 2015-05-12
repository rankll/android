package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dominio.Coisa;
import progamaro.rankll.R;

/**
 * Created by helio on 10/05/15.
 */
public class CoisaAdapter extends ArrayAdapter<Coisa> {

    private final Context context;
    private final List<Coisa> items;

    public CoisaAdapter(Context context, List<Coisa> values) {
        super(context, R.layout.coisa_listagem_item, values);
        this.context = context;
        this.items = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.coisa_listagem_item, parent, false);

        ImageView imagem;
        TextView nome;
        TextView descricao;
        LinearLayout linearLayout;

        imagem = (ImageView)rowView.findViewById(R.id.iv_coisa_detalhes_imagem);
        nome = (TextView)rowView.findViewById(R.id.tv_item_nome_coisa);
        descricao = (TextView)rowView.findViewById(R.id.tv_item_descricao_coisa);
        linearLayout = (LinearLayout)rowView.findViewById(R.id.ll_item_coisa);

        Coisa objCoisa = items.get(position);
        nome.setText(objCoisa.getNome());
        descricao.setText(objCoisa.getDescricao());
        //imagem.setImageResource(R.mipmap.ic_launcher);

        return rowView;
    }
}
