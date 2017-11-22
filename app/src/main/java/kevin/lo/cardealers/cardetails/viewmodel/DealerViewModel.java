package kevin.lo.cardealers.cardetails.viewmodel;

import kevin.lo.cardealers.cardetails.view.DealerView;
import kevin.lo.cardealers.models.Dealer;


public class DealerViewModel implements DealerView.Model {

    private String dealerName;
    private String phone = "not available";
    private Double latitude;
    private Double longitude;
    private DealerView.DirectionsCallback callback;

    public DealerViewModel(Dealer dealer, DealerView.DirectionsCallback callback) {
        this.dealerName = dealer.getName();
        if (dealer.getContactInfo() != null) {
            this.phone = dealer.getContactInfo().getPhone();
        }

        if (dealer.getAddress() != null) {
            this.latitude = dealer.getAddress().getLatitude();
            this.longitude = dealer.getAddress().getLongitude();
        }
        this.callback = callback;
    }

    @Override
    public String getDealerName() {
        return dealerName;
    }

    @Override
    public String getPhoneNumber() {
        return phone;
    }

    @Override
    public Double getDealerLocationLatitude() {
        return latitude;
    }

    @Override
    public Double getDealerLocationLongitude() {
        return longitude;
    }

    @Override
    public DealerView.DirectionsCallback getCallback() {
        return callback;
    }
}
