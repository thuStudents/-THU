//package de.thu;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertFalse;
//import static junit.framework.TestCase.assertNotNull;
//import static junit.framework.TestCase.assertNull;
//import static junit.framework.TestCase.assertSame;
//import static junit.framework.TestCase.assertTrue;
//
//import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.platform.app.InstrumentationRegistry;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//
//public class LoginActivityTest {
//
//    @Rule
//    public ActivityScenarioRule<LoginActivity> mActivityTestRule
//            = new ActivityScenarioRule<>(LoginActivity.class);
//    public LoginActivity loginActivity;
//
//    @Before
//    public void setup() {
//        mActivityTestRule.getScenario().onActivity(activity -> {
//            loginActivity = activity;
//            if( FirebaseAuth.getInstance().getCurrentUser()!= null) {
//                FirebaseAuth.getInstance().signOut();
//            }
//        });
//    }
//
//    @Test
//    public void testLoginSuccessful(){
//        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
//            @Override
//            public void run() {
//                EditText email = loginActivity.findViewById(R.id.inputEmail);
//                EditText pass = loginActivity.findViewById(R.id.inputPassword);
//                Button loginBtn = loginActivity.findViewById(R.id.buttonLogin);
//                email.setText("adelabela2526@gmail.com");
//                pass.setText("654321");
//                loginBtn.performClick();
//                Log.d("USER123", email.getText().toString());
//
//                String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//                Log.d("USER123", user);
//                //Log.d("USER123", email.toString());
//                assertNull(user);
//
//                //assertEquals("message" , user, email.getText().toString() );
//            }
//        });
//    }
//
//    @Test
//    public void testLoginFailed(){
//        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
//            @Override
//            public void run() {
//                EditText email = loginActivity.findViewById(R.id.inputEmail);
//                EditText pass = loginActivity.findViewById(R.id.inputPassword);
//                email.setText("aaa");
//                pass.setText("123");
//                Button loginBtn = loginActivity.findViewById(R.id.buttonLogin);
//                loginBtn.performClick();
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                Log.d("USER0000" , user.getEmail());
//                assertNull(user);
//            }
//        });
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        FirebaseAuth.getInstance().signOut();
//        loginActivity = null;
//    }
//}
