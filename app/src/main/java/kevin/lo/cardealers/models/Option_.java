
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("equipmentType")
    @Expose
    private String equipmentType;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("manufactureOptionName")
    @Expose
    private String manufactureOptionName;
    @SerializedName("manufactureOptionCode")
    @Expose
    private String manufactureOptionCode;
    @SerializedName("description")
    @Expose
    private String description;

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getManufactureOptionName() {
        return manufactureOptionName;
    }

    public void setManufactureOptionName(String manufactureOptionName) {
        this.manufactureOptionName = manufactureOptionName;
    }

    public String getManufactureOptionCode() {
        return manufactureOptionCode;
    }

    public void setManufactureOptionCode(String manufactureOptionCode) {
        this.manufactureOptionCode = manufactureOptionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
