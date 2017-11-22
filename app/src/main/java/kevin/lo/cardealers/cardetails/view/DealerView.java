package kevin.lo.cardealers.cardetails.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kevin.lo.cardealers.R;


public class DealerView extends RelativeLayout {

    public interface DirectionsCallback {
        void onDirectionsButtonClicked(Double latitude, Double longitude);
    }

    public interface Model {
        String getDealerName();
        String getPhoneNumber();
        Double getDealerLocationLatitude();
        Double getDealerLocationLongitude();
        DirectionsCallback getCallback();
    }

    private TextView dealerName;
    private TextView phoneNumber;
    private Button directions;

    public DealerView(Context context) {
        super(context);
        init(context);
    }

    public DealerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DealerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public DealerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void setModel(final Model model) {
        dealerName.setText(model.getDealerName());
        phoneNumber.setText(model.getPhoneNumber());
        directions.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                model.getCallback().onDirectionsButtonClicked(
                        model.getDealerLocationLatitude(),
                        model.getDealerLocationLongitude()
                );
            }
        });
    }

    private void init(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_dealer, this);
        dealerName = v.findViewById(R.id.dealer_name);
        phoneNumber = v.findViewById(R.id.dealer_phone);
        directions = v.findViewById(R.id.directions);
    }
}
