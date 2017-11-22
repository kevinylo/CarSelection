package kevin.lo.cardealers.cardetails.viewmodel;

import kevin.lo.cardealers.cardetails.view.EngineView;
import kevin.lo.cardealers.models.Engine;


public class EngineViewModel implements EngineView.Model {

    private String name;
    private Double compressionRatio;
    private Integer cylinder;
    private Double size;
    private String configuration;
    private Integer horsePower;
    private Integer torque;
    private Integer totalValves;
    private String type;
    private String valveTiming;
    private String valveGear;

    public EngineViewModel(Engine engine) {
        name = engine.getName();
        compressionRatio = engine.getCompressionRatio();
        cylinder = engine.getCylinder();
        size = engine.getSize();
        configuration = engine.getConfiguration();
        horsePower = engine.getHorsepower();
        torque = engine.getTorque();
        totalValves = engine.getTotalValves();
        type = engine.getType();
        if (engine.getValve() != null) {
            valveTiming = engine.getValve().getTiming();
            valveGear = engine.getValve().getGear();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCompressionRatio() {
        return compressionRatio;
    }

    @Override
    public Integer getCylinder() {
        return cylinder;
    }

    @Override
    public Double getSize() {
        return size;
    }

    @Override
    public String getConfiguration() {
        return configuration;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public Integer getTorque() {
        return torque;
    }

    @Override
    public Integer getTotalValves() {
        return totalValves;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getValveTiming() {
        return valveTiming;
    }

    @Override
    public String getValveGear() {
        return valveGear;
    }

}
