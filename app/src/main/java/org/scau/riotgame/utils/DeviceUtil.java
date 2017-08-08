package org.scau.riotgame.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by ZP on 2017/8/3.
 */

public class DeviceUtil {

    public static String getICCID(Context context) {
        TelephonyManager telecomManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telecomManager.getSimSerialNumber();
    }

    public static String getPhoneNumber(Context context) {
        TelephonyManager telecomManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telecomManager.getLine1Number();
    }
}
