import java.time.ZonedDateTime;

/**
 * @author qiujianping
 * @date Created in 2021/5/28 16:34
 */
public class Test01 {
    public static void main(String[] args) {
        // 默认时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
