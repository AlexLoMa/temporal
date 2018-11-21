package com.sam.samproject;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import com.sam.samproject.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;

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

public class MortgageApplicationInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

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

        //  Automate Mortage Form
        MortgageFormAutomation();

        //Espresso.pressBack();
    }

    private void MortgageFormAutomation() {
        onView(withId(R.id.img_mortage_app)).perform(click());

        /* For Customer Personal Information */
        onView(allOf(isDescendantOfA(withId(R.id.salutation)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "Sal"));
        onView(allOf(isDescendantOfA(withId(R.id.firstname)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "First_Name"));
        onView(allOf(isDescendantOfA(withId(R.id.initial)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "I"));
        onView(allOf(isDescendantOfA(withId(R.id.lastname)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "Last_Name"));
        onView(allOf(isDescendantOfA(withId(R.id.birthdate)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "01/01/2000"));
        onView(allOf(isDescendantOfA(withId(R.id.work_num)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "604-435-0009"));
        onView(allOf(isDescendantOfA(withId(R.id.cell_num)), isAssignableFrom(EditText.class)))
                .perform(clearText(), typeText( "698-567-8765"));
        onView(allOf(isDescendantOfA(withId(R.id.email_address)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "harminder@domain.com"));
        onView(allOf(isDescendantOfA(withId(R.id.contact_method)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "phone"));
        onView(allOf(isDescendantOfA(withId(R.id.dependents)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "12"));
        onView(allOf(isDescendantOfA(withId(R.id.apt_no)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "30"));
        onView(allOf(isDescendantOfA(withId(R.id.street_name)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "Sawmill"));
        onView(allOf(isDescendantOfA(withId(R.id.city)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "Columbus"));
        onView(allOf(isDescendantOfA(withId(R.id.state)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "Ohio"));
        onView(allOf(isDescendantOfA(withId(R.id.zipcode)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "43017"));
        onView(allOf(isDescendantOfA(withId(R.id.status)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "B"));
        onView(allOf(isDescendantOfA(withId(R.id.rentpay)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "$45"));
        onView(allOf(isDescendantOfA(withId(R.id.years)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "2000"));
        onView(allOf(isDescendantOfA(withId(R.id.months)), isAssignableFrom(EditText.class)))
                .perform(clearText(),typeText( "Dec"));

        /* For Customer address details */
        // onView(withId(R.id.zip_code)).perform(click());
    }
}
