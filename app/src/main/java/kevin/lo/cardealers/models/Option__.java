
package kevin.lo.cardealers.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option__ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("equipmentType")
    @Expose
    private String equipmentType;
    @SerializedName("manufactureOptionName")
    @Expose
    private String manufactureOptionName;
    @SerializedName("manufactureOptionCode")
    @Expose
    private String manufactureOptionCode;
    @SerializedName("colorChips")
    @Expose
    private ColorChips colorChips;
    @SerializedName("fabricTypes")
    @Expose
    private List<FabricType> fabricTypes = null;

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

    public ColorChips getColorChips() {
        return colorChips;
    }

    public void setColorChips(ColorChips colorChips) {
        this.colorChips = colorChips;
    }

    public List<FabricType> getFabricTypes() {
        return fabricTypes;
    }

    public void setFabricTypes(List<FabricType> fabricTypes) {
        this.fabricTypes = fabricTypes;
    }

}
