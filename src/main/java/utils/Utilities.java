package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }


}
