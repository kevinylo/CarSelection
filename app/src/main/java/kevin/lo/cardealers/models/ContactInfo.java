
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactInfo {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("gpContactFirstName")
    @Expose
    private String gpContactFirstName;
    @SerializedName("gpContactLastName")
    @Expose
    private String gpContactLastName;
    @SerializedName("gpContactEmail")
    @Expose
    private String gpContactEmail;
    @SerializedName("gpCommitment")
    @Expose
    private String gpCommitment;
    @SerializedName("gpPhone")
    @Expose
    private String gpPhone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGpContactFirstName() {
        return gpContactFirstName;
    }

    public void setGpContactFirstName(String gpContactFirstName) {
        this.gpContactFirstName = gpContactFirstName;
    }

    public String getGpContactLastName() {
        return gpContactLastName;
    }

    public void setGpContactLastName(String gpContactLastName) {
        this.gpContactLastName = gpContactLastName;
    }

    public String getGpContactEmail() {
        return gpContactEmail;
    }

    public void setGpContactEmail(String gpContactEmail) {
        this.gpContactEmail = gpContactEmail;
    }

    public String getGpCommitment() {
        return gpCommitment;
    }

    public void setGpCommitment(String gpCommitment) {
        this.gpCommitment = gpCommitment;
    }

    public String getGpPhone() {
        return gpPhone;
    }

    public void setGpPhone(String gpPhone) {
        this.gpPhone = gpPhone;
    }

}
