package Skau.kds;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Time Utilities
 */
public class DateTimeUtils {
    //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    public static String getTime(Date d){
        SimpleDateFormat f = new SimpleDateFormat("hh:mm a");
        String s = f.format(d);
        return s;
    }
}
