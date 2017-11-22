
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories {

    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("EPAClass")
    @Expose
    private String ePAClass;
    @SerializedName("vehicleSize")
    @Expose
    private String vehicleSize;
    @SerializedName("crossover")
    @Expose
    private String crossover;
    @SerializedName("primaryBodyType")
    @Expose
    private String primaryBodyType;
    @SerializedName("vehicleStyle")
    @Expose
    private String vehicleStyle;
    @SerializedName("vehicleType")
    @Expose
    private String vehicleType;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getEPAClass() {
        return ePAClass;
    }

    public void setEPAClass(String ePAClass) {
        this.ePAClass = ePAClass;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getCrossover() {
        return crossover;
    }

    public void setCrossover(String crossover) {
        this.crossover = crossover;
    }

    public String getPrimaryBodyType() {
        return primaryBodyType;
    }

    public void setPrimaryBodyType(String primaryBodyType) {
        this.primaryBodyType = primaryBodyType;
    }

    public String getVehicleStyle() {
        return vehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
