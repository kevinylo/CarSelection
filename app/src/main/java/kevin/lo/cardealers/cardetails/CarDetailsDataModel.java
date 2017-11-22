package kevin.lo.cardealers.cardetails;

import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Styles;

public class CarDetailsDataModel {

    private Styles styles;
    private Articles articles;

    public CarDetailsDataModel(Styles styles, Articles articles) {
        this.styles = styles;
        this.articles = articles;
    }

    public Styles getStyles() {
        return styles;
    }

    public void setStyles(Styles styles) {
        this.styles = styles;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }
}
