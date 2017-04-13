package com.androidcourse.larryzzl.savingmanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zzhang on 13/04/2017.
 */

public class Utils {

    public static String formatDate(Date data, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
        return formatter.format(data);
    }
}
