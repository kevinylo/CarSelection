package kevin.lo.cardealers.cardetails;

import java.util.List;

import kevin.lo.cardealers.models.Article;
import kevin.lo.cardealers.models.Dealer;
import kevin.lo.cardealers.models.Style;


public interface CarDetails {

    interface View {
        void setStyleView(List<Style> styleList);
        void setArticleView(List<Article> articleList);
        void hideDetailViews();
        void hideArticleView();
        void showErrorView();
        void hideDealerInfo();
        void setDealerView(Dealer dealer);
        void showDirections(Double latitude, Double longitude);
    }

    interface Presenter {
        void release();
        void getDetailedInformation(String makeName, String modelName, int year);
        void getDealerInformation(String makeName, Double latitude, Double longitude);
    }
}
