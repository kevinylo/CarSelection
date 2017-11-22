package kevin.lo.cardealers.cardetails;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import kevin.lo.cardealers.models.AddressComponent;
import kevin.lo.cardealers.models.Article;
import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Result;
import kevin.lo.cardealers.models.Results;
import kevin.lo.cardealers.models.Style;
import kevin.lo.cardealers.models.Styles;
import repository.Repository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class CarDetailsPresenterTest {

    CarDetailsPresenter presenter;
    CarDetailsActivity view = mock(CarDetailsActivity.class);
    Repository repository = mock(Repository.class);

    @Before
    public void setUp() {
        presenter = new CarDetailsPresenter(view, repository);
    }

    @Test
    public void getZipCodeFromAddressResultsCase1() {
        // Arrange
        // postal address component
        AddressComponent postalComponent = new AddressComponent();
        List<String> types = new ArrayList<>();
        types.add("postal_code");
        postalComponent.setTypes(types);
        postalComponent.setLongName("91360");

        // country component
        AddressComponent countryComponent = new AddressComponent();
        types = new ArrayList<>();
        types.add("country");
        types.add("political");
        countryComponent.setTypes(types);
        countryComponent.setLongName("United States");

        List<AddressComponent> addressComponentList = new ArrayList<>();
        addressComponentList.add(postalComponent);
        addressComponentList.add(countryComponent);

        List<Result> resultList = new ArrayList<>();
        Result result = mock(Result.class);
        when(result.getAddressComponents()).thenReturn(addressComponentList);
        resultList.add(result);

        Results results = new Results();
        results.setResults(resultList);

        // Act
        String returnedZipcode = presenter.getZipCodeFromAddressResults(results);

        // Verify
        assertEquals(returnedZipcode, "91360");
    }

    @Test
    public void getZipCodeFromAddressResultsCase2() {
        // Arrange
        // postal address component
        AddressComponent postalComponent = new AddressComponent();
        List<String> types = new ArrayList<>();
        types.add("postalcode");
        postalComponent.setTypes(types);
        postalComponent.setLongName("91360");

        List<AddressComponent> addressComponentList = new ArrayList<>();
        addressComponentList.add(postalComponent);

        List<Result> resultList = new ArrayList<>();
        Result result = mock(Result.class);
        when(result.getAddressComponents()).thenReturn(addressComponentList);
        resultList.add(result);

        Results results = new Results();
        results.setResults(resultList);

        // Act
        String returnedZipcode = presenter.getZipCodeFromAddressResults(results);

        // Verify
        assertEquals(returnedZipcode, CarDetailsPresenter.DEFAULT_ZIPCODE);
    }

    @Test
    public void getZipCodeFromAddressResultsCase3() {
        // Arrange
        List<Result> resultList = new ArrayList<>();
        Result result = null;
        resultList.add(result);

        Results results = new Results();
        results.setResults(resultList);

        // Act
        String returnedZipcode = presenter.getZipCodeFromAddressResults(results);

        // Verify
        assertEquals(returnedZipcode, CarDetailsPresenter.DEFAULT_ZIPCODE);
    }

    @Test
    public void processRetrievedModelErrorCase() {
        // Arrange
        CarDetailsDataModel carDetailsDataModel = null;

        // Act
        presenter.processRetrievedModel(carDetailsDataModel);

        // Verify
        verify(view).hideDetailViews();
        verify(view).showErrorView();
    }

    @Test
    public void processRetrievedModel1() {
        // Arrange
        Styles styles = new Styles();
        List<Style> styleList = new ArrayList<>();
        Style style = new Style();
        styleList.add(style);
        styles.setStyles(styleList);

        Articles articles = new Articles();
        List<Article> articleList = new ArrayList<>();
        Article article = new Article();
        articleList.add(article);
        articles.setArticles(articleList);

        CarDetailsDataModel carDetailsDataModel = new CarDetailsDataModel(styles, articles);

        // Act
        presenter.processRetrievedModel(carDetailsDataModel);

        // Verify
        verify(view).setStyleView(styleList);
        verify(view).setArticleView(articleList);
    }

    @Test
    public void processRetrievedModel2() {
        // Arrange
        Styles styles = new Styles();
        List<Style> styleList = new ArrayList<>();
        Style style = new Style();
        styleList.add(style);
        styles.setStyles(styleList);

        Articles articles = new Articles();
        List<Article> articleList = new ArrayList<>();
        articles.setArticles(articleList);

        CarDetailsDataModel carDetailsDataModel = new CarDetailsDataModel(styles, articles);

        // Act
        presenter.processRetrievedModel(carDetailsDataModel);

        // Verify
        verify(view).setStyleView(styleList);
        verify(view).hideArticleView();
    }
}
