package fr.guddy.androidvip.ui.main;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import fr.guddy.androidvip.R;
import fr.guddy.androidvip.rules.AndroidVIPApplicationRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainActivityTest {
    @Rule
    public AndroidVIPApplicationRule mRule = new AndroidVIPApplicationRule();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Mock
    public MvpMain.Interactor mInteractor;

    @Test
    public void testDisplayResult() {
        when(mInteractor.compute(anyInt(), anyInt())).thenReturn(2);

        mActivityTestRule.launchActivity(null);
        onView(withId(R.id.ActivityMain_EditText_A)).perform(typeText("4"));
        onView(withId(R.id.ActivityMain_EditText_B)).perform(typeText("8"));
        onView(withId(R.id.ActivityMain_Button_Compute)).perform(click());

        verify(mInteractor).compute(4, 8);
        onView(withId(R.id.ActivityMain_TextViewResult)).check(matches(withText("2")));
    }
}
