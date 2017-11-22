package kevin.lo.cardealers.modelselection;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.models.Model;


public class ModelListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Model> models;

    private ModelListViewHolder.OnModelClickListener onModelClickListener;

    public ModelListAdapter(List<Model> models) {
        this.models = models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_cell, parent, false);
        return new ModelListViewHolder(parent.getContext(), view, onModelClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ModelListViewHolder modelListViewHolder = (ModelListViewHolder) holder;
        modelListViewHolder.initialize(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setOnModelClickListener(ModelListViewHolder.OnModelClickListener onModelClickListener) {
        this.onModelClickListener = onModelClickListener;
    }
}
