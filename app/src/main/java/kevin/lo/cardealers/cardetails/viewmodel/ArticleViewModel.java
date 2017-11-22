package kevin.lo.cardealers.cardetails.viewmodel;

import kevin.lo.cardealers.cardetails.view.ArticleView;
import kevin.lo.cardealers.models.Article;


public class ArticleViewModel implements ArticleView.Model {

    private String title;
    private String url;

    public ArticleViewModel(Article article) {
        this.title = article.getTitle();
        if (article.getLink() != null) {
            this.url = article.getLink().getHref();
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
