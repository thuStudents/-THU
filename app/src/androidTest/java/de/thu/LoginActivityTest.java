package de.thu;

import static junit.framework.TestCase.assertTrue;

import android.widget.Button;
import android.widget.EditText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityTestRule
            = new ActivityScenarioRule<>(LoginActivity.class);
    public LoginActivity loginActivity;

    @Before
    public void setup() {
        mActivityTestRule.getScenario().onActivity(activity -> {
            loginActivity = activity;
        });
    }

    @Test
    public void testLogin(){

        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                EditText email = loginActivity.findViewById(R.id.inputEmail);
                EditText pass = loginActivity.findViewById(R.id.inputPassword);
//                email.setText("adelabela2526@gmail.com");
//                pass.setText("654321");
                email.setText("aaa");
                pass.setText("123");
                Button loginBtn = loginActivity.findViewById(R.id.buttonLogin);
                loginBtn.performClick();
                assertTrue(loginActivity.isCurUserLoggedIn());
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        loginActivity = null;
    }
}
