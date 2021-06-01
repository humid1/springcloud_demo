import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qiujianping
 * @date Created in 2021/5/28 16:34
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("******* 只适用于 JDK 1.8 以上 *****************");
        // 默认时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime); // 结果：2021-05-31T16:32:19.622+08:00[Asia/Shanghai]
        // 使用 LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format); // 结果：2021-05-31 16:32:19
        // 获取后5天日期
        LocalDateTime localDateTime1 = localDateTime.plusDays(5);
        System.out.println(localDateTime1);// 结果：2021-06-05T16:32:19.622
        // 获取前5天日期
        LocalDateTime localDateTime2 = localDateTime.minusDays(5);
        System.out.println(localDateTime2);// 结果：2021-05-26T16:32:19.622
        // LocalTime (HH:mm:ss:SSS)
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime); // 结果：16:32:19.647
        // LocalDate (yyyy-MM-dd)
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate); // 结果：2021-05-31

        System.out.println("*********** Calendar ***********");
        Calendar calendar = Calendar.getInstance();
        // 获取前5天日期
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DATE, -1);
            System.out.println(calendar.getTime());
        }
    }
}
