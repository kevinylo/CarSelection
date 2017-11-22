package kevin.lo.cardealers.cardetails.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.helper.WebViewActivity;


public class ArticleView extends LinearLayout {

    public interface Model {
        String getTitle();
        String getUrl();
    }

    private TextView title;
    private Button urlButton;
    private Model[] articleModels;
    private Context context;
    private LinearLayout articlesLinearLayout;

    public ArticleView(Context context) {
        super(context);
        this.context = context;
    }

    public ArticleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public ArticleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public ArticleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    public void setModel(final Model[] articleModels) {
        this.articleModels = articleModels;
        int numberOfArticles = articleModels.length;

        View rootView = LayoutInflater.from(context).inflate(R.layout.view_articles, this);
        articlesLinearLayout = rootView.findViewById(R.id.article_list);

        for (int i = 0; i < numberOfArticles; i++) {
            View articleCellView = LayoutInflater.from(context).inflate(R.layout.cell_article, articlesLinearLayout, false);
            title = articleCellView.findViewById(R.id.article_label);
            urlButton = articleCellView.findViewById(R.id.article_button);

            final Model articleModel = articleModels[i];
            title.setText(articleModel.getTitle());
            urlButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(WebViewActivity.URL, articleModel.getUrl());
                    context.startActivity(intent);
                }
            });
            articlesLinearLayout.addView(articleCellView);
        }
    }
}
