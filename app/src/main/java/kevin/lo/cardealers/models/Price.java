
package kevin.lo.cardealers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("baseMSRP")
    @Expose
    private Integer baseMSRP;
    @SerializedName("baseInvoice")
    @Expose
    private Integer baseInvoice;
    @SerializedName("deliveryCharges")
    @Expose
    private Integer deliveryCharges;
    @SerializedName("usedTmvRetail")
    @Expose
    private Integer usedTmvRetail;
    @SerializedName("usedPrivateParty")
    @Expose
    private Integer usedPrivateParty;
    @SerializedName("usedTradeIn")
    @Expose
    private Integer usedTradeIn;
    @SerializedName("estimateTmv")
    @Expose
    private Boolean estimateTmv;
    @SerializedName("tmvRecommendedRating")
    @Expose
    private Integer tmvRecommendedRating;

    public Integer getBaseMSRP() {
        return baseMSRP;
    }

    public void setBaseMSRP(Integer baseMSRP) {
        this.baseMSRP = baseMSRP;
    }

    public Integer getBaseInvoice() {
        return baseInvoice;
    }

    public void setBaseInvoice(Integer baseInvoice) {
        this.baseInvoice = baseInvoice;
    }

    public Integer getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }


    public Integer getUsedTmvRetail() {
        return usedTmvRetail;
    }

    public void setUsedTmvRetail(Integer usedTmvRetail) {
        this.usedTmvRetail = usedTmvRetail;
    }

    public Integer getUsedPrivateParty() {
        return usedPrivateParty;
    }

    public void setUsedPrivateParty(Integer usedPrivateParty) {
        this.usedPrivateParty = usedPrivateParty;
    }

    public Integer getUsedTradeIn() {
        return usedTradeIn;
    }

    public void setUsedTradeIn(Integer usedTradeIn) {
        this.usedTradeIn = usedTradeIn;
    }

    public Boolean getEstimateTmv() {
        return estimateTmv;
    }

    public void setEstimateTmv(Boolean estimateTmv) {
        this.estimateTmv = estimateTmv;
    }

    public Integer getTmvRecommendedRating() {
        return tmvRecommendedRating;
    }

    public void setTmvRecommendedRating(Integer tmvRecommendedRating) {
        this.tmvRecommendedRating = tmvRecommendedRating;
    }

}
