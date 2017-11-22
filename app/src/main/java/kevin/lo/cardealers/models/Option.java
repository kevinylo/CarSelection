
package kevin.lo.cardealers.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("options")
    @Expose
    private List<Option_> options = null;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Option_> getOptions() {
        return options;
    }

    public void setOptions(List<Option_> options) {
        this.options = options;
    }

}
