package org.iilab.pb;

import android.content.Intent;
import android.content.SharedPreferences;

import org.iilab.pb.common.ApplicationSettings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowPreferenceManager;

import static org.junit.Assert.assertNotNull;

//import org.iilab.pb.HomeActivity;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class HomeActivityTest {
    private HomeActivity homeActivity;
    private ShadowActivity shadowActivity;

    @Before
    public void setUp() {
        homeActivity = new HomeActivity();
        shadowActivity = Shadows.shadowOf(homeActivity);
    }


    @Test
    public void shouldInitializeData() {

    }

    @Test
    public void shouldUpdateDataAndDisplayWizardWhenUserHasNotFinishedTheWizard() {
        setFirstRun(true);
//        homeActivity.onCreate(null);

//        assertNull(shadowActivity.getNextStartedActivity());
    }

    @Test
    public void shouldUpdateDataAndStartCalculatorFacadeWhenUserCompletedWizard() {
        setFirstRun(false);
//        homeActivity.onCreate(null);

        Intent startedIntent = shadowActivity.getNextStartedActivity();
//        assertEquals(CalculatorActivity.class.getName(), startedIntent.getComponent().getClassName());
    }


    @Test
    public void shouldDisplayWizardWhenUserHasNotFinishedTheWizard() {
        setFirstRun(true);
//        homeActivity.onCreate(null);

//        assertNull(shadowActivity.getNextStartedActivity());
    }

    @Test
    public void shouldStartCalculatorFacadeWhenUserCompletedWizard() {
        setFirstRun(false);
//        homeActivity.onCreate(null);

        Intent startedIntent = shadowActivity.getNextStartedActivity();
//        assertEquals(CalculatorActivity.class.getName(), startedIntent.getComponent().getClassName());
    }

    @Test
    public void shouldReturnAnInstance() {
        assertNotNull(new ApplicationSettings());
    }

    private void setFirstRun(boolean flag) {
        SharedPreferences sharedPreferences = ShadowPreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("FIRST_RUN", flag);
        editor.commit();
    }
}
