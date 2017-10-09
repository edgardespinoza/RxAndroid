package everis.rx.com.rxandroid;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class sumarTesting {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sumarTesting() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText = onView(
                withId(R.id.id_a));
        textInputEditText.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText2 = onView(
                withId(R.id.id_b));
        textInputEditText2.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.idsumar), withText("sumar"),
                        withParent(withId(R.id.layout_adicion))));
        appCompatButton.perform(scrollTo(), click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_next), withText("Siguiente"), isDisplayed()));
        appCompatButton2.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText3 = onView(
                withId(R.id.id_a));
        textInputEditText3.perform(scrollTo(), replaceText("4"), closeSoftKeyboard());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction textInputEditText4 = onView(
                withId(R.id.id_b));
        textInputEditText4.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.idsumar), withText("Restar"),
                        withParent(withId(R.id.layout_adicion))));
        appCompatButton3.perform(scrollTo(), click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_next), withText("Siguiente"), isDisplayed()));
        appCompatButton4.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText5 = onView(
                withId(R.id.id_a));
        textInputEditText5.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText6 = onView(
                withId(R.id.id_b));
        textInputEditText6.perform(scrollTo(), replaceText("4"), closeSoftKeyboard());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.idsumar), withText("Multiplicar"),
                        withParent(withId(R.id.layout_adicion))));
        appCompatButton5.perform(scrollTo(), click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btn_next), withText("Siguiente"), isDisplayed()));
        appCompatButton6.perform(click());

    }

}
