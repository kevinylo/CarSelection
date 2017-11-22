package kevin.lo.cardealers.cardetails.viewmodel;


import kevin.lo.cardealers.cardetails.view.PriceView;
import kevin.lo.cardealers.models.Price;

public class PriceViewModel implements PriceView.Model {

    private Integer baseMsrp;
    private Integer baseInvoice;
    private Integer usedTmvRetail;
    private Integer usedPrivateParty;
    private Integer usedTradeIn;

    public PriceViewModel(Price price) {
        baseMsrp = price.getBaseMSRP();
        baseInvoice = price.getBaseInvoice();
        usedTmvRetail = price.getUsedTmvRetail();
        usedPrivateParty = price.getUsedPrivateParty();
        usedTradeIn = price.getUsedTradeIn();
    }

    @Override
    public Integer getBaseMsrp() {
        return baseMsrp;
    }

    @Override
    public Integer getBaseInvoice() {
        return baseInvoice;
    }

    @Override
    public Integer getUsedTmvRetail() {
        return usedTmvRetail;
    }

    @Override
    public Integer getUsedPrivateParty() {
        return usedPrivateParty;
    }

    @Override
    public Integer getUsedTradeIn() {
        return usedTradeIn;
    }
}
