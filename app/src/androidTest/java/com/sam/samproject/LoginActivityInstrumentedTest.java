package com.sam.samproject;

/**
 * Created by Alejandro Lopez on 25/09/2018.
 */


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.KeyEvent;

import com.sam.samproject.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityInstrumentedTest {

    public static String SELECT_ROLE = "Select your Role";

    @Rule
    //public IntentsTestRule<LoginActivity> mActivityRule = new IntentsTestRule<>(LoginActivity.class);
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void newTest(){
        onView(withId(R.id.spRole))
                .perform(click())
                .perform(pressKey(KeyEvent.ACTION_DOWN))
                .perform(click())
                .check(matches(withText(SELECT_ROLE)));
    }
}


