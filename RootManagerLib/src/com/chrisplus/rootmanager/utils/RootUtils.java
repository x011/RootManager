
package com.chrisplus.rootmanager.utils;

import com.chrisplus.rootmanager.RootManager;
import com.chrisplus.rootmanager.container.Command;

import android.os.Looper;
import android.util.Log;

/**
 * This class is a set of methods used in {@link RootManager}.
 * 
 * @author Chris
 */
public class RootUtils {

    private final static String TAG = "RootManager";
    private static int cmdID = 0;

    /**
     * To check if the caller is on the ui thread, throw exception if it calls
     * on UI thread.
     */
    public static void checkUIThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Please do not call this fuction on UI thread");
        }
    }

    /**
     * Output log to logcat as the debug level.
     * 
     * @param message
     */
    public static void Log(String message) {
        Log.d(TAG, message);
    }

    /**
     * Output log to logcat as the debug level with extend log tag.
     * <p>
     * The example: LibTag::YourExtendTag, Log Message.
     * </p>
     * 
     * @param extendTag Your extend tag.
     * @param message
     */
    public static void Log(String extendTag, String message) {
        Log.d(TAG + "::" + extendTag, message);
    }

    /**
     * Get a command Id for each {@link Command}.
     * 
     * @return the actual ID.
     */
    public static int generateCommandID() {
        cmdID = cmdID + 1;
        RootUtils.Log("Return a command id " + cmdID);
        return cmdID;
    }

    /**
     * Check if command need patch.
     * 
     * @return
     */
    public static boolean isNeedPathSDK() {
        return android.os.Build.VERSION.SDK_INT == 17;
    }
}
