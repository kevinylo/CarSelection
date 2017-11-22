
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Engine {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("equipmentType")
    @Expose
    private String equipmentType;
    @SerializedName("compressionRatio")
    @Expose
    private Double compressionRatio;
    @SerializedName("cylinder")
    @Expose
    private Integer cylinder;
    @SerializedName("size")
    @Expose
    private Double size;
    @SerializedName("displacement")
    @Expose
    private Integer displacement;
    @SerializedName("configuration")
    @Expose
    private String configuration;
    @SerializedName("fuelType")
    @Expose
    private String fuelType;
    @SerializedName("horsepower")
    @Expose
    private Integer horsepower;
    @SerializedName("torque")
    @Expose
    private Integer torque;
    @SerializedName("totalValves")
    @Expose
    private Integer totalValves;
    @SerializedName("manufacturerEngineCode")
    @Expose
    private String manufacturerEngineCode;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("compressorType")
    @Expose
    private String compressorType;
    @SerializedName("rpm")
    @Expose
    private Rpm rpm;
    @SerializedName("valve")
    @Expose
    private Valve valve;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(Double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public Integer getCylinder() {
        return cylinder;
    }

    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }

    public Integer getTotalValves() {
        return totalValves;
    }

    public void setTotalValves(Integer totalValves) {
        this.totalValves = totalValves;
    }

    public String getManufacturerEngineCode() {
        return manufacturerEngineCode;
    }

    public void setManufacturerEngineCode(String manufacturerEngineCode) {
        this.manufacturerEngineCode = manufacturerEngineCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public Rpm getRpm() {
        return rpm;
    }

    public void setRpm(Rpm rpm) {
        this.rpm = rpm;
    }

    public Valve getValve() {
        return valve;
    }

    public void setValve(Valve valve) {
        this.valve = valve;
    }

}
