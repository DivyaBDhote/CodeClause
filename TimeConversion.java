import java.util.Date;
import java.util.TimeZone;

public class TimeConversion {

    public static void main(String[] args) {
        // Get the current time in PST
        Date currentDate = new Date();
        TimeZone pstTimeZone = TimeZone.getTimeZone("PST");

        // Convert the current time to GMT
        Date gmtDate = new Date(currentDate.getTime() - pstTimeZone.getRawOffset());

        // Print the current time in PST and GMT
        System.out.println("Current time in PST: " + currentDate);
        System.out.println("Current time in GMT: " + gmtDate);

        // Convert the current time to the time in London
        TimeZone londonTimeZone = TimeZone.getTimeZone("Europe/London");
        Date londonDate = new Date(currentDate.getTime() - pstTimeZone.getRawOffset() + londonTimeZone.getRawOffset());

        // Print the current time in London
        System.out.println("Current time in London: " + londonDate);
    }
}
