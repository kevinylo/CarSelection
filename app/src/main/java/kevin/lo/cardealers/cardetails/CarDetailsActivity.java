package kevin.lo.cardealers.cardetails;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import kevin.lo.cardealers.R;
import kevin.lo.cardealers.cardetails.view.ArticleView;
import kevin.lo.cardealers.cardetails.view.DealerView;
import kevin.lo.cardealers.cardetails.view.EngineView;
import kevin.lo.cardealers.cardetails.view.PriceView;
import kevin.lo.cardealers.cardetails.view.VehicleView;
import kevin.lo.cardealers.cardetails.viewmodel.ArticleViewModel;
import kevin.lo.cardealers.cardetails.viewmodel.DealerViewModel;
import kevin.lo.cardealers.cardetails.viewmodel.EngineViewModel;
import kevin.lo.cardealers.cardetails.viewmodel.PriceViewModel;
import kevin.lo.cardealers.cardetails.viewmodel.VehicleViewModel;
import kevin.lo.cardealers.helper.LocationPermissionHelper;
import kevin.lo.cardealers.models.Article;
import kevin.lo.cardealers.models.Dealer;
import kevin.lo.cardealers.models.Style;

import static android.view.View.GONE;


public class CarDetailsActivity extends AppCompatActivity implements CarDetails.View,
        LocationPermissionHelper.LocationListener {

    private static final String MAP_NAVIGATION_INTENT_PREFIX = "google.navigation:q=";
    private static final String MAP_NAVIGATION_INTENT_SEPERATOR = ",";
    public static final String MAKE_NAME = "make_name";
    public static final String MODEL_NAME = "model_name";
    public static final String YEAR = "year";

    @Inject
    CarDetailsPresenter carDetailsPresenter;

    private String makeName;
    private String modelName;
    private int year;

    private VehicleView vehicleView;
    private PriceView priceView;
    private EngineView engineView;
    private ArticleView articleView;
    private DealerView dealerView;
    private TextView errorView;
    private LocationPermissionHelper locationPermissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_details);

        makeName = getIntent().getStringExtra(MAKE_NAME);
        modelName = getIntent().getStringExtra(MODEL_NAME);
        year = getIntent().getIntExtra(YEAR, -1);

        vehicleView = findViewById(R.id.vehicle);
        priceView = findViewById(R.id.price);
        engineView = findViewById(R.id.engine);
        articleView = findViewById(R.id.articles);
        dealerView = findViewById(R.id.dealer);
        errorView = findViewById(R.id.error);

        locationPermissionHelper = new LocationPermissionHelper(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carDetailsPresenter.getDetailedInformation(makeName, modelName, year);

        // Activity (view) listens for location because Location is an Android concept
        locationPermissionHelper.setLocationListener(this);
        locationPermissionHelper.checkPermissionToGetLocation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        carDetailsPresenter.release();
    }

    @Override
    public void setStyleView(List<Style> styleList) {
        Style style = styleList.get(0);
        VehicleViewModel vehicleViewModel = new VehicleViewModel(style);
        vehicleView.setModel(vehicleViewModel);

        EngineViewModel engineViewModel = new EngineViewModel(style.getEngine());
        engineView.setModel(engineViewModel);

        PriceViewModel priceViewModel = new PriceViewModel(style.getPrice());
        priceView.setModel(priceViewModel);
    }

    @Override
    public void setArticleView(List<Article> articleList) {
        int numberOfArticles = articleList.size();
        ArticleViewModel[] articleViewModels = new ArticleViewModel[numberOfArticles];

        for (int i = 0; i < numberOfArticles; i++) {
            ArticleViewModel articleViewModel = new ArticleViewModel(articleList.get(i));
            articleViewModels[i] = articleViewModel;
        }
        articleView.setModel(articleViewModels);
    }

    @Override
    public void setDealerView(Dealer dealer) {
        DealerViewModel dealerViewModel = new DealerViewModel(dealer, carDetailsPresenter);
        dealerView.setModel(dealerViewModel);
    }

    @Override
    public void hideDetailViews() {
        vehicleView.setVisibility(GONE);
        priceView.setVisibility(GONE);
        engineView.setVisibility(GONE);
        articleView.setVisibility(GONE);
        dealerView.setVisibility(GONE);
    }

    @Override
    public void hideArticleView() {
        articleView.setVisibility(GONE);
    }

    @Override
    public void showErrorView() {
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDealerInfo() {
        dealerView.setVisibility(GONE);
    }

    @Override
    public void showDirections(Double latitude, Double longitude) {
        Uri gmmIntentUri = Uri.parse(MAP_NAVIGATION_INTENT_PREFIX
                + latitude
                + MAP_NAVIGATION_INTENT_SEPERATOR
                + longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    public void onLastLocationObtained(Location location) {
        Toast.makeText(this, "location obtained", Toast.LENGTH_LONG).show();
        carDetailsPresenter.getDealerInformation(makeName, location.getLatitude(),
                location.getLongitude());
    }

    @Override
    public void onFailedLocationRequest(Exception e) {
        Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationDenied() {
        Toast.makeText(this, "location denied", Toast.LENGTH_LONG).show();
    }
}
