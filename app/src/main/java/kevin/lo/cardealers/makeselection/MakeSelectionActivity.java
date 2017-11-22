package kevin.lo.cardealers.makeselection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.models.Make;
import kevin.lo.cardealers.modelselection.ModelSelectionActivity;

public class MakeSelectionActivity extends AppCompatActivity implements MakeSelection.View {

    @Inject
    MakeSelectionPresenter makeSelectionPresenter;

    private RecyclerView recyclerView;

    private MakeListAdapter makeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
        Toolbar toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.make_list);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        makeSelectionPresenter.getMakes();
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeSelectionPresenter.release();
    }

    @Override
    public void initializeListAdapter(List<Make> makes) {
        makeListAdapter = new MakeListAdapter(makes);
        makeListAdapter.setOnMakeClickListener(makeSelectionPresenter);
        recyclerView.setAdapter(makeListAdapter);
    }

    @Override
    public void startModelSelection(String makeName) {
        Intent intent = new Intent(this, ModelSelectionActivity.class);
        intent.putExtra(ModelSelectionActivity.MAKE_NAME, makeName);
        startActivity(intent);
    }

    private void init() {
        // Initialize the recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
