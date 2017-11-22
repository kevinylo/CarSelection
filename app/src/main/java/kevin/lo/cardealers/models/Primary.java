
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Primary {

    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("g")
    @Expose
    private Integer g;
    @SerializedName("b")
    @Expose
    private Integer b;
    @SerializedName("hex")
    @Expose
    private String hex;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

}
