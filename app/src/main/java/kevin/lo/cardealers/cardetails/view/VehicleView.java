package kevin.lo.cardealers.cardetails.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import kevin.lo.cardealers.R;
import kevin.lo.cardealers.helper.PicassoFactory;


public class VehicleView extends LinearLayout {

    private Context context;

    public interface Model {
        String getImageUrl();
        String getMakeName();
        String getModelName();
        String getDriveWheels();
        String getLongName();
    }

    private ImageView carImage;
    private TextView makeName;
    private TextView modelName;
    private TextView driveWheels;
    private TextView longName;

    public VehicleView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public VehicleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public VehicleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public VehicleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init();
    }

    public void setModel(Model model) {
        makeName.setText(model.getMakeName());
        modelName.setText(model.getModelName());
        driveWheels.setText(model.getDriveWheels());
        longName.setText(model.getLongName());

        PicassoFactory.INSTANCE.getPicasso(context).load(model.getImageUrl()).into(carImage);
    }

    private void init() {
        View v = LayoutInflater.from(context).inflate(R.layout.view_vehicle, this);
        carImage = v.findViewById(R.id.f3q);
        makeName = v.findViewById(R.id.make_name);
        modelName = v.findViewById(R.id.model_name);
        driveWheels = v.findViewById(R.id.drive_wheels);
        longName = v.findViewById(R.id.long_name);
    }
}
