package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Makes {

    @SerializedName("makes")
    @Expose
    private List<Make> makes = null;

    public List<Make> getMakes() {
        return makes;
    }

    public void setMakes(List<Make> makes) {
        this.makes = makes;
    }
}
