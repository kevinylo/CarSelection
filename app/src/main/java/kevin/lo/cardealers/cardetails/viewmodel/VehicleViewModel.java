package kevin.lo.cardealers.cardetails.viewmodel;


import kevin.lo.cardealers.cardetails.view.VehicleView;
import kevin.lo.cardealers.models.Style;


public class VehicleViewModel implements VehicleView.Model {

    private static final String IMAGE_URL_HEAD = "https://a.tcimg.net/v/model_images/v1/";
    private static final String IMAGE_URL_TAIL = "/all/190x97/f3q";
    private static final String SLASH = "/";

    private int year;
    private String makeName;
    private String modelName;
    private String driveWheels;
    private String longName;
    private String imageUrl;

    public VehicleViewModel(Style style) {
        this.year = style.getYear().getYear();
        this.makeName = style.getMake().getNiceName();
        this.modelName = style.getModel().getNiceName();
        this.driveWheels = style.getDrivenWheels();
        this.longName = style.getName();

        this.imageUrl = createImageUrl();
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String getMakeName() {
        return makeName;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String getDriveWheels() {
        return driveWheels;
    }

    @Override
    public String getLongName() {
        return longName;
    }

    private String createImageUrl() {
        StringBuilder sb = new StringBuilder();
        return sb.append(IMAGE_URL_HEAD)
                .append(year).append(SLASH)
                .append(makeName).append(SLASH)
                .append(modelName)
                .append(IMAGE_URL_TAIL).toString();
    }
}
