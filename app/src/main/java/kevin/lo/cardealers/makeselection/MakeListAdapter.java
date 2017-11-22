package kevin.lo.cardealers.makeselection;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.models.Make;


public class MakeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Make> makes;

    private MakeListViewHolder.OnMakeClickListener onMakeClickListener;

    public MakeListAdapter(List<Make> makes) {
        this.makes = makes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.make_cell, parent, false);
        return new MakeListViewHolder(parent.getContext(), view, onMakeClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MakeListViewHolder makeListViewHolder = (MakeListViewHolder) holder;
        makeListViewHolder.initialize(makes.get(position));
    }

    @Override
    public int getItemCount() {
        return makes.size();
    }

    public void setOnMakeClickListener(MakeListViewHolder.OnMakeClickListener onMakeClickListener) {
        this.onMakeClickListener = onMakeClickListener;
    }
}
