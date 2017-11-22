package kevin.lo.cardealers.modelselection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.models.Model;


public class ModelListViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private OnModelClickListener onModelClickListener;
    private View itemView;

    public interface OnModelClickListener {
        void onModelClicked(Model model);
    }

    public ModelListViewHolder(Context context, View itemView, OnModelClickListener onModelClickListener) {
        super(itemView);
        this.itemView = itemView;
        this.context = context;
        this.onModelClickListener = onModelClickListener;
    }

    public void initialize(final Model model) {
        TextView textView = itemView.findViewById(R.id.model_name);
        textView.setText(model.getName());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onModelClickListener.onModelClicked(model);
            }
        });
    }
}
