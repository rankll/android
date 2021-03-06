package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        super(context, R.layout.coisa_listagem_item_grid, values);
        this.context = context;
        this.items = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.coisa_listagem_item_grid, parent, false);

        ImageView imagem;
        TextView sigla;
        TextView descricao;
        LinearLayout linearLayout;

        imagem = (ImageView)rowView.findViewById(R.id.iv_item_coisa_grid);
        sigla = (TextView)rowView.findViewById(R.id.tv_item_sigla_coisa_grid);
        descricao = (TextView)rowView.findViewById(R.id.tv_item_descr_coisa_grid);
        //linearLayout = (LinearLayout)rowView.findViewById(R.id.ll_item_coisa);

        Coisa objCoisa = items.get(position);
        sigla.setText(objCoisa.getDescription().substring(0,1).toUpperCase());
        descricao.setText(objCoisa.getDescription());

        if (objCoisa.getId().equals("5")) {
            imagem.setVisibility(View.VISIBLE);
            sigla.setVisibility(View.GONE);
        }
        //imagem.setImageResource(R.mipmap.ic_launcher);

        return rowView;
    }
}
