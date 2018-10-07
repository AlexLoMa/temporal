package com.sam.samproject.base;

/**
 * Created by Alejandro Lopez on 20/09/2018.
 */

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    public static String TAG = BaseActivity.class.getName();

    protected boolean mIsDexMode;
    protected boolean mIsStandaloneMode;
    protected boolean mIsDexDualMode;


    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Dex-Mode Enabled=" + mIsDexMode + ", isDualMode=" + mIsDexDualMode + ", isStandaloneMode=" + mIsStandaloneMode, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mIsDexMode = checkDeXEnabled();
        Log.d(TAG, "mIsDexMode=" + mIsDexMode);
        checkModes();
    }

    private boolean checkDeXEnabled(){
        boolean enabled;
        Configuration config = getResources().getConfiguration();
        try {
            Class configClass = config.getClass();
            if (configClass.getField("SEM_DESKTOP_MODE_ENABLED").getInt(configClass)
                    == configClass.getField("semDesktopModeEnabled").getInt(config)) {
                enabled = true;
            } else {
                enabled = false;
            }
            return enabled;
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        }
        return false;
    }

    private void checkModes() {
        Object desktopModeManager = getApplicationContext().getSystemService("desktopmode");
        if (desktopModeManager != null) {
            try {
                Method getDesktopModeStateMethod = desktopModeManager.getClass().getDeclaredMethod("getDesktopModeState");
                Object desktopModeState = getDesktopModeStateMethod.invoke(desktopModeManager);

                Class desktopModeStateClass = desktopModeState.getClass();

                Method getEnabledMethod = desktopModeStateClass.getDeclaredMethod("getEnabled");
                int enabled = (int) getEnabledMethod.invoke(desktopModeState);
                boolean isEnabled = enabled == desktopModeStateClass.getDeclaredField("ENABLED").getInt(desktopModeStateClass);

                Method getDisplayTypeMethod = desktopModeStateClass.getDeclaredMethod("getDisplayType");
                int displayType = (int) getDisplayTypeMethod.invoke(desktopModeState);
                mIsDexDualMode = isEnabled && displayType == desktopModeStateClass.getDeclaredField("DISPLAY_TYPE_DUAL").getInt(desktopModeStateClass);
                mIsStandaloneMode = isEnabled && displayType == desktopModeStateClass.getDeclaredField("DISPLAY_TYPE_STANDALONE").getInt(desktopModeStateClass);

                // Check isEnabled, isDualMode or isStandaloneMode as you want
                Log.d(TAG, "isEnabled=" + isEnabled + ", isDualMode=" + mIsDexDualMode + ", isStandaloneMode=" + mIsStandaloneMode);
            } catch (NoSuchFieldException | NoSuchMethodException |
                    IllegalAccessException | InvocationTargetException e) {
                // Device does not support DeX 3.0
            }
        } else {
            // Device does not support Samsung DeX or called too early on boot
        }
    }
}
