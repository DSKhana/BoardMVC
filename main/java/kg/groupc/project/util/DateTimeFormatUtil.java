package kg.groupc.project.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * 날짜 시간 포맷변경 유틸
 *
 * @Author 김경일
 * @Date 2021/08/11
 */
public class DateTimeFormatUtil {
    public static String changeToYMD(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String changeToYMDHM(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
    }
}
