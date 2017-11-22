package kevin.lo.cardealers.modelselection;


import java.util.List;

import kevin.lo.cardealers.models.Model;
import kevin.lo.cardealers.models.Year;

public interface ModelSelection {

    interface Presenter {
        void getModels(String makeName);
        void release();
        void goToCarDetails(int year);
    }

    interface View {
        void initializeListAdapter(List<Model> models);
        void populateYearRange(int min, int max);
        void startCarDetailsActivity(String makeName, String modelName, int year);
    }
}
