package com.sam.samproject;

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
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
public class LoginActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

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

    @Test
    public void RelationshipManagerTest () {
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

            // Find the Submit button and click on it.
            onView(withId(R.id.btnSubmit)).perform(click());
            Espresso.pressBack();

    }

       @Test
       public void PersonalBankerTest () {
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

        // Find the Submit button and click on it.
        onView(withId(R.id.btnSubmit)).perform(click());
        Espresso.pressBack();

    }
       @Test
       public void BranchManagerTest () {
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

        // Find the Submit button and click on it.
         onView(withId(R.id.btnSubmit)).perform(click());
         Espresso.pressBack();

         }

       }
