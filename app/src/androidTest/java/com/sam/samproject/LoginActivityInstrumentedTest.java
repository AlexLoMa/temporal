package com.sam.samproject;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import com.sam.samproject.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
public class LoginActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void A_RelationshipManagerTest () {

        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        // find the spinner and click on it.
        onView(withId(R.id.spRole)).perform(click());
        //Find Spinner Item and click on it.
        onData(is(myArray[1])).perform(click());
        // enter Username
        //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
        // the above command to typeText was not working due to TextInputLayout, so need to write as below.
        onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("relmanager1" ));
        Espresso.closeSoftKeyboard();
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("123456" ));
        Espresso.closeSoftKeyboard();

        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        // Espresso.pressBack();
    }


    @Test
    public void B_PersonalBankerTest () {

        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        // find the spinner and click on it.
        onView(withId(R.id.spRole)).perform(click());
        //Find Spinner Item and click on it.
        onData(is(myArray[2])).perform(click());
        // enter Username
        //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
        // the above command to typeText was not working due to TextInputLayout, so need to write as below.
        onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("personalbanker1"));
        Espresso.closeSoftKeyboard();
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("123456"));

        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());

        //Espresso.pressBack();
    }


    @Test
    public void C_BranchManagerTest () {

        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        // find the spinner and click on it.
        onView(withId(R.id.spRole)).perform(click());
        //Find Spinner Item and click on it.
        onData(is(myArray[3])).perform(click());
        // enter Username
        //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
        // the above command to typeText was not working due to TextInputLayout, so need to write as below.
        onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("branchmanager1" ));
        Espresso.closeSoftKeyboard();
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("123456"));
        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        // Espresso.pressBack();
      }
}
