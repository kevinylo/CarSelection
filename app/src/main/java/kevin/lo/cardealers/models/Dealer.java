
package kevin.lo.cardealers.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dealer {

    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("exclusions")
    @Expose
    private List<Object> exclusions = null;
    @SerializedName("dealerId")
    @Expose
    private String dealerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("niceName")
    @Expose
    private String niceName;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("operations")
    @Expose
    private Operations operations;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("contactInfo")
    @Expose
    private ContactInfo contactInfo;
    @SerializedName("reviews")
    @Expose
    private Reviews reviews;
    @SerializedName("states")
    @Expose
    private List<String> states = null;
    @SerializedName("type")
    @Expose
    private String type;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Object> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<Object> exclusions) {
        this.exclusions = exclusions;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
