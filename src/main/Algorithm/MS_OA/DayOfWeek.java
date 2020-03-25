import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {

    private static String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static Map<String, Integer> dayToNum = new HashMap<>();
    static {
        dayToNum.put("Sun", 0);
        dayToNum.put("Mon", 1);
        dayToNum.put("Tue", 2);
        dayToNum.put("Wed", 3);
        dayToNum.put("Thu", 4);
        dayToNum.put("Fri", 5);
        dayToNum.put("Sat", 6);

    }
    public static void main(String[] args) {

//        String s1 = "a";
//        String s1 = "abaaa";
//        String s1 = "abaaa";abaaa
        String day = "Sat";
        System.out.println(getDayOfWeek(day, 23));
    }

    public static String getDayOfWeek(String day, int k) {

        if (!dayToNum.containsKey(day) || k < 0) {
            return null;
        }

        int  targetDayNum = (dayToNum.get(day) + k) % 7 ;
        return days[targetDayNum];
    }

}
