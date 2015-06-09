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
public class CoisaInicialAdapter extends ArrayAdapter<Coisa> {

    private final Context context;
    private final List<Coisa> items;

    public CoisaInicialAdapter(Context context, List<Coisa> values) {
        super(context, R.layout.coisa_listagem_item_grid, values);
        this.context = context;
        this.items = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.coisa_listagem_item_grid, parent, false);

        TextView nome;
        TextView descricao;
        LinearLayout linearLayout;

        nome = (TextView)rowView.findViewById(R.id.tv_item_nome_coisa);
        descricao = (TextView)rowView.findViewById(R.id.tv_item_descricao_coisa);
        linearLayout = (LinearLayout)rowView.findViewById(R.id.ll_item_coisa);

        Coisa objCoisa = items.get(position);
        nome.setText(objCoisa.getName());
        descricao.setText(objCoisa.getDescription());

        return rowView;
    }
}
