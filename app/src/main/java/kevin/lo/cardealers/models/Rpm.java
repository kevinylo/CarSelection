
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rpm {

    @SerializedName("horsepower")
    @Expose
    private Integer horsepower;
    @SerializedName("torque")
    @Expose
    private Integer torque;

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

}
