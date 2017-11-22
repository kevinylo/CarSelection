package kevin.lo.cardealers.cardetails.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.models.Price;


public class PriceView extends LinearLayout {

    public interface Model {
        Integer getBaseMsrp();
        Integer getBaseInvoice();
        Integer getUsedTmvRetail();
        Integer getUsedPrivateParty();
        Integer getUsedTradeIn();
    }

    private TextView baseMsrp;
    private TextView baseInvoice;
    private TextView usedTmvRetail;
    private TextView usedPrivateParty;
    private TextView usedTradeIn;

    public PriceView(Context context) {
        super(context);
        init(context);
    }

    public PriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PriceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public PriceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void setModel(PriceView.Model model) {
        baseMsrp.setText(String.valueOf(model.getBaseMsrp()));
        baseInvoice.setText(String.valueOf(model.getBaseInvoice()));
        usedTmvRetail.setText(String.valueOf(model.getUsedTmvRetail()));
        usedPrivateParty.setText(String.valueOf(model.getUsedPrivateParty()));
        usedTradeIn.setText(String.valueOf(model.getUsedTradeIn()));
    }

    private void init(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_price, this);
        baseMsrp = v.findViewById(R.id.baseMsrp);
        baseInvoice = v.findViewById(R.id.baseInvoice);
        usedTmvRetail = v.findViewById(R.id.usedTmvRetail);
        usedPrivateParty = v.findViewById(R.id.usedPrivateParty);
        usedTradeIn = v.findViewById(R.id.usedTradeIn);
    }
}
