//package de.thu;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.filters.LargeTest;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(AndroidJUnit4.class)
//    @LargeTest
//    public class HomepageTest {
//
//        private String stringToBetyped;
//
//        @Rule
//        public ActivityScenarioRule<HomeActivity> activityRule
//                = new ActivityScenarioRule<>(HomeActivity.class);
//
//        @Before
//        public void initValidString() {
//            // Specify a valid string.
//            stringToBetyped = "Espresso";
//        }
//
//        @Test
//        public void changeText_sameActivity() {
//            // Type text and then press the button.
//            onView(withId(R.id.editTextUserInput))
//                    .perform(typeText(stringToBetyped), closeSoftKeyboard());
//            onView(withId(R.id.changeTextBt)).perform(click());
//
//            // Check that the text was changed.
//            onView(withId(R.id.textToBeChanged))
//                    .check(matches(withText(stringToBetyped)));
//        }
//    }
//}
