package utils;

import java.util.UUID;

/**
 * @author wei.li
 * @date 2018/11/18 10:17
 * @desc
 */
public class FilekeyUtil {

    public static String generateFileKey(){
      return  UUID.randomUUID().toString();
    }
}
