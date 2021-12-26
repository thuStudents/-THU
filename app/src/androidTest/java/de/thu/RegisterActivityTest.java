//package de.thu;
//
//import static junit.framework.TestCase.assertFalse;
//import static junit.framework.TestCase.assertTrue;
//
//import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.platform.app.InstrumentationRegistry;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.EmailAuthProvider;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.SignInMethodQueryResult;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//
//public class RegisterActivityTest {
//
//    @Rule
//    public ActivityScenarioRule<RegisterActivity> mActivityTestRule
//            = new ActivityScenarioRule<>(RegisterActivity.class);
//    public RegisterActivity registerActivity;
//
//    @Before
//    public void setup() {
//        mActivityTestRule.getScenario().onActivity(activity -> {
//            registerActivity = activity;
//        });
//    }
//
//    @Test
//    public void testRegister(){
//        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
//            @Override
//            public void run() {
//                EditText email = registerActivity.findViewById(R.id.inputEmail);
//                EditText username = registerActivity.findViewById(R.id.username);
//                EditText pass1 = registerActivity.findViewById(R.id.inputPassword);
//                EditText pass2 = registerActivity.findViewById(R.id.confirmPassword);
//                email.setText("aaa");
//                username.setText("dajena");
//                pass1.setText("654321");
//                pass2.setText("654321");
//                Button registerBtn = registerActivity.findViewById(R.id.buttonRegister);
//                registerBtn.performClick();
//
////                final boolean[] userExists = new boolean[1];
//
//                FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email.toString())
//                        .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
//
//                                assertFalse(task.getResult().getSignInMethods().isEmpty());
//
//                            }
//                        });
//            }
//        });
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
////        AuthCredential credential = EmailAuthProvider.getCredential(email, password);
//        user.delete();
//        registerActivity = null;
//    }
//}
