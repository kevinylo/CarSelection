package kevin.lo.cardealers.makeselection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.models.Make;


public class MakeListViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private OnMakeClickListener onMakeClickListener;
    private View itemView;

    public interface OnMakeClickListener {
        void onMakeClicked(Make make);
    }

    public MakeListViewHolder(Context context, View itemView, OnMakeClickListener onMakeClickListener) {
        super(itemView);
        this.itemView = itemView;
        this.context = context;
        this.onMakeClickListener = onMakeClickListener;
    }

    public void initialize(final Make make) {
        TextView textView = itemView.findViewById(R.id.make_name);
        textView.setText(make.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMakeClickListener.onMakeClicked(make);
            }
        });
    }
}
