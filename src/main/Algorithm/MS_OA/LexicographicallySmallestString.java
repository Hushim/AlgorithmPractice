import java.util.Arrays;

public class LexicographicallySmallestString {
    public static void main(String[] args) {
        System.out.println(getLLS("abcd"));
    }

    public static String getLLS(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        for (int i = 0; i <= s.length() - 2; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return s.substring(0, i) + s.substring(i + 1);
            }
        }

        return s.substring(0, s.length() - 1);
    }
}
