
package kevin.lo.cardealers.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Style {

    @SerializedName("make")
    @Expose
    private Make make;
    @SerializedName("model")
    @Expose
    private Model model;
    @SerializedName("engine")
    @Expose
    private Engine engine;
    @SerializedName("transmission")
    @Expose
    private Transmission transmission;
    @SerializedName("drivenWheels")
    @Expose
    private String drivenWheels;
    @SerializedName("numOfDoors")
    @Expose
    private String numOfDoors;
    @SerializedName("options")
    @Expose
    private List<Option> options = null;
    @SerializedName("colors")
    @Expose
    private List<Color> colors = null;
    @SerializedName("manufacturerCode")
    @Expose
    private String manufacturerCode;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("categories")
    @Expose
    private Categories categories;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year")
    @Expose
    private Year year;
    @SerializedName("submodel")
    @Expose
    private Submodel submodel;
    @SerializedName("trim")
    @Expose
    private String trim;
    @SerializedName("states")
    @Expose
    private List<String> states = null;
    @SerializedName("squishVins")
    @Expose
    private List<String> squishVins = null;
    @SerializedName("MPG")
    @Expose
    private MPG mPG;

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getDrivenWheels() {
        return drivenWheels;
    }

    public void setDrivenWheels(String drivenWheels) {
        this.drivenWheels = drivenWheels;
    }

    public String getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(String numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Submodel getSubmodel() {
        return submodel;
    }

    public void setSubmodel(Submodel submodel) {
        this.submodel = submodel;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<String> getSquishVins() {
        return squishVins;
    }

    public void setSquishVins(List<String> squishVins) {
        this.squishVins = squishVins;
    }

    public MPG getMPG() {
        return mPG;
    }

    public void setMPG(MPG mPG) {
        this.mPG = mPG;
    }

}
