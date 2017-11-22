package kevin.lo.cardealers.makeselection;


import java.util.List;

import kevin.lo.cardealers.models.Make;

public interface MakeSelection {

    interface Presenter{
        void getMakes();
        void release();
    }

    interface View {
        void initializeListAdapter(List<Make> makes);
        void startModelSelection(String makeName);
    }
}
