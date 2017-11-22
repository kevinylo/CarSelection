package kevin.lo.cardealers.cardetails.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kevin.lo.cardealers.R;


public class EngineView extends RelativeLayout {
    public interface Model {
        String getName();
        Double getCompressionRatio();
        Integer getCylinder();
        Double getSize();
        String getConfiguration();
        Integer getHorsePower();
        Integer getTorque();
        Integer getTotalValves();
        String getType();
        String getValveTiming();
        String getValveGear();
    }

    private TextView name;
    private TextView compressionRatio;
    private TextView cylinder;
    private TextView size;
    private TextView configuration;
    private TextView horsepower;
    private TextView torque;
    private TextView totalValves;
    private TextView type;
    private TextView valveTiming;
    private TextView valveGear;

    public EngineView(Context context) {
        super(context);
        init(context);
    }

    public EngineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EngineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public EngineView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void setModel(EngineView.Model model) {
        name.setText(model.getName());
        compressionRatio.setText(String.valueOf(model.getCompressionRatio()));
        cylinder.setText(String.valueOf(model.getCylinder()));
        size.setText(String.valueOf(model.getSize()));
        configuration.setText(model.getConfiguration());
        horsepower.setText(String.valueOf(model.getHorsePower()));
        torque.setText(String.valueOf(model.getTorque()));
        totalValves.setText(String.valueOf(model.getTotalValves()));
        type.setText(model.getType());
        valveTiming.setText(model.getValveTiming());
        valveGear.setText(model.getValveGear());
    }

    private void init(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_engine, this);
        name = v.findViewById(R.id.name);
        compressionRatio = v.findViewById(R.id.compressionRatio);
        cylinder = v.findViewById(R.id.cylinder);
        size = v.findViewById(R.id.size);
        configuration = v.findViewById(R.id.configuration);
        horsepower = v.findViewById(R.id.horsepower);
        torque = v.findViewById(R.id.torque);
        totalValves = v.findViewById(R.id.total_valves);
        type = v.findViewById(R.id.type);
        valveTiming = v.findViewById(R.id.valve_timing);
        valveGear = v.findViewById(R.id.valve_gear);
    }
}
