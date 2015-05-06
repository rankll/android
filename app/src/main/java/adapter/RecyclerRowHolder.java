package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by helio on 05/05/15.
 */
public class RecyclerRowHolder extends RecyclerView.ViewHolder {
    protected TextView id;
    protected TextView descricao;
    private TextView nota;

    public RecyclerRowHolder(View view){
        super(view);

    }
}
