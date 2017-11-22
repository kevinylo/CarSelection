package kevin.lo.cardealers.modelselection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import kevin.lo.cardealers.R;
import kevin.lo.cardealers.cardetails.CarDetailsActivity;
import kevin.lo.cardealers.models.Model;


public class ModelSelectionActivity extends AppCompatActivity implements ModelSelection.View {

    public static final String MAKE_NAME = "make_name";

    private String makeName;
    private RecyclerView recyclerView;
    private ModelListAdapter modelListAdapter;
    private NumberPicker yearPicker;
    private Button confirm;
    private Model selectedModel;

    @Inject
    ModelSelectionPresenter modelSelectionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_selection_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);

        makeName = getIntent().getStringExtra(MAKE_NAME);

        recyclerView = findViewById(R.id.model_list);
        yearPicker = findViewById(R.id.year_picker);
        yearPicker.setWrapSelectorWheel(false);
        confirm = findViewById(R.id.model_confirm);


        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        modelSelectionPresenter.getModels(makeName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        modelSelectionPresenter.release();
    }

    @Override
    public void initializeListAdapter(List<Model> models) {
        modelListAdapter = new ModelListAdapter(models);
        modelListAdapter.setOnModelClickListener(modelSelectionPresenter);
        recyclerView.setAdapter(modelListAdapter);
    }

    @Override
    public void populateYearRange(int min, int max) {
        yearPicker.setMinValue(min);
        yearPicker.setMaxValue(max);
    }

    @Override
    public void startCarDetailsActivity(String makeName, String modelName, int year) {
        Intent intent = new Intent(this, CarDetailsActivity.class);
        intent.putExtra(CarDetailsActivity.MAKE_NAME, makeName);
        intent.putExtra(CarDetailsActivity.MODEL_NAME, modelName);
        intent.putExtra(CarDetailsActivity.YEAR, year);
        startActivity(intent);
    }

    private void init() {
        // Initialize the recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelSelectionPresenter.goToCarDetails(yearPicker.getValue());
            }
        });
    }
}
