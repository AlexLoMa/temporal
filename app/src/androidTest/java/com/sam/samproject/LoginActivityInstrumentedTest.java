package com.sam.samproject;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import com.sam.samproject.login.LoginActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    /*
    @Test
    public void itrateSpinnerItems() {
        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        int size = myArray.length;
        for (int i = 1; i < size; i++) {
            // find the spinner and click on it.
            onView(withId(R.id.spRole)).perform(click());
            //Find Spinner Item and click on it.
            onData(is(myArray[i])).perform(click());
            // enter Username
            //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
            // the above command to typeText was not working due to TextInputLayout, so need to write as below.
            onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                    .perform(clearText(), typeText("UserName" + ' ' + i));
            // enter password
            onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                    .perform(clearText(), typeText("Password" + ' ' + i));
            // Find the Submit button and click on it.
            onView(withId(R.id.btnSubmit)).perform(click());
            Espresso.pressBack();
        }
    }
    */

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
                .perform(clearText(), typeText("UserName" + ' ' + 1));
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("Password" + ' ' + 1));
        Espresso.closeSoftKeyboard();

        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        Espresso.pressBack();
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
                .perform(clearText(), typeText("UserName" + ' ' + 2));
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("Password" + ' ' + 2));

        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        Espresso.pressBack();
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
                .perform(clearText(), typeText("UserName" + ' ' + 3));
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("Password" + ' ' + 3));
        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
         onView(withId(R.id.btnSubmit)).perform(click());
         Espresso.pressBack();
    }

    @Test
    public void D_RelationshipManagerLandscapeTest () {
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        // find the spinner and click on it.
        onView(withId(R.id.spRole)).perform(click());
        //Find Spinner Item and click on it.
        onData(is(myArray[1])).perform(click());
        // enter Username
        //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
        // the above command to typeText was not working due to TextInputLayout, so need to write as below.
        onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("UserName" + ' ' + 1));
        Espresso.closeSoftKeyboard();
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("Password" + ' ' + 1));
        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Espresso.pressBack();
    }

    @Test
    public void E_PersonalBankerLandscapeTest () {
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        // find the spinner and click on it.
        onView(withId(R.id.spRole)).perform(click());
        //Find Spinner Item and click on it.
        onData(is(myArray[2])).perform(click());
        // enter Username
        //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
        // the above command to typeText was not working due to TextInputLayout, so need to write as below.
        onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("UserName" + ' ' + 2));
        Espresso.closeSoftKeyboard();
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("Password" + ' ' + 2));
        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Espresso.pressBack();
    }

    @Test
    public void F_BranchManagerLandscapeTest () {
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.role);
        // find the spinner and click on it.
        onView(withId(R.id.spRole)).perform(click());
        //Find Spinner Item and click on it.
        onData(is(myArray[3])).perform(click());
        // enter Username
        //onView(withId(R.id.inputUserName)).perform(click()).perform(typeText("a"));
        // the above command to typeText was not working due to TextInputLayout, so need to write as below.
        onView(allOf(isDescendantOfA(withId(R.id.inputUserName)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("UserName" + ' ' + 3));
        Espresso.closeSoftKeyboard();
        // enter password
        onView(allOf(isDescendantOfA(withId(R.id.inputPassword)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText("Password" + ' ' + 3));
        Espresso.closeSoftKeyboard();
        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Espresso.pressBack();
    }

}
