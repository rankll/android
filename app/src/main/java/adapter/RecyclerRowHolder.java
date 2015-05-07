package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by helio on 05/05/15.
 */
public class RecyclerRowHolder extends RecyclerView.ViewHolder {
    private Context context;
    public TextView id;
    public TextView descricao;

    public RecyclerRowHolder(Context context, View itemView){
        super(itemView);
        this.context = context;
        //id = (TextView)itemView.findViewById(R.id.tv_id);
        //nome = (TextView)itemView.findViewById(R.id.tv_nome);
    }
}
