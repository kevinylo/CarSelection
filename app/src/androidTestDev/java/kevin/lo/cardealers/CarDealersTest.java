package kevin.lo.cardealers;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.Espresso;

import kevin.lo.cardealers.makeselection.MakeSelectionActivity;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class CarDealersTest {
    @Rule
    public ActivityTestRule<MakeSelectionActivity> testRule = new ActivityTestRule<>(
            MakeSelectionActivity.class);

    @Test
    public void makeSelectionToModelSelection() {
        // Act
        Espresso.onView(withId(R.id.make_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Verify
        Espresso.onView(withId(R.id.model_list)).check(matches(isDisplayed()));
    }

}
