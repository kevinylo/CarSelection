
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transmission {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("equipmentType")
    @Expose
    private String equipmentType;
    @SerializedName("automaticType")
    @Expose
    private String automaticType;
    @SerializedName("transmissionType")
    @Expose
    private String transmissionType;
    @SerializedName("numberOfSpeeds")
    @Expose
    private String numberOfSpeeds;

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

    public String getAutomaticType() {
        return automaticType;
    }

    public void setAutomaticType(String automaticType) {
        this.automaticType = automaticType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public void setNumberOfSpeeds(String numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }

}
