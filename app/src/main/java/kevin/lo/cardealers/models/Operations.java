
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operations {

    @SerializedName("Wednesday")
    @Expose
    private String wednesday;
    @SerializedName("Tuesday")
    @Expose
    private String tuesday;
    @SerializedName("Thursday")
    @Expose
    private String thursday;
    @SerializedName("Saturday")
    @Expose
    private String saturday;
    @SerializedName("Friday")
    @Expose
    private String friday;
    @SerializedName("Monday")
    @Expose
    private String monday;
    @SerializedName("Sunday")
    @Expose
    private String sunday;

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

}
