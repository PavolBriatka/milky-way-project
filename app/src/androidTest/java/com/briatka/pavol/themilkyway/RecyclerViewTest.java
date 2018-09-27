package com.briatka.pavol.themilkyway;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.briatka.pavol.themilkyway.views.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;
    private RecyclerView recyclerView;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
        recyclerView = mActivity.findViewById(R.id.main_recycler_view);
    }

    @Test
    public void RecyclerViewCreatedAndVisible() {
        Assert.assertNotNull(recyclerView);
        Espresso.onView(withId(R.id.main_recycler_view)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void RecyclerViewScrollsToLastPosition() {
        int position = recyclerView.getAdapter().getItemCount() - 1;
        Espresso.onView(withId(R.id.main_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(position)).check(ViewAssertions.matches(isDisplayed()));
    }

}
