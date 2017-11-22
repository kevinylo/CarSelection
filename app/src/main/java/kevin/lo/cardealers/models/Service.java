
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("overallRating")
    @Expose
    private Double overallRating;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("recommendedCount")
    @Expose
    private Integer recommendedCount;
    @SerializedName("notRecommendedCount")
    @Expose
    private Integer notRecommendedCount;

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRecommendedCount() {
        return recommendedCount;
    }

    public void setRecommendedCount(Integer recommendedCount) {
        this.recommendedCount = recommendedCount;
    }

    public Integer getNotRecommendedCount() {
        return notRecommendedCount;
    }

    public void setNotRecommendedCount(Integer notRecommendedCount) {
        this.notRecommendedCount = notRecommendedCount;
    }

}
