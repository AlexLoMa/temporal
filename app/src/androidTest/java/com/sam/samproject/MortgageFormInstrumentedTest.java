package com.sam.samproject;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import com.sam.samproject.login.LoginActivity;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

public class MortgageFormInstrumentedTest {

    @Rule
    public ActivityTestRule<PersonalBankerActivity> mpActivityRule = new ActivityTestRule<>(PersonalBankerActivity.class);

    @Test
    public void B_PersonalBankerTest () {

          mpActivityRule.getActivity().getResources();
        // find the spinner and click on it.
         MortgageFormAutomation();
        //Espresso.pressBack();
    }

    private void MortgageFormAutomation() {
       //onView(withId(R.id.account_open)).perform(click());

        onView(withId(R.id.img_mortage_app)).perform(click());

        //onView(allOf(isDescendantOfA(withId(R.id.name)), isAssignableFrom(EditText.class)))
        //        .perform(clearText(), typeText("Name"));

        //onView(allOf(isDescendantOfA(withId(R.id.nameEditText)), isAssignableFrom(EditText.class)))
        //    .perform(clearText(), typeText("F_Name"));

        Espresso.closeSoftKeyboard();

      }

   }
