import java.util.*;

public class SemiAlternatingSubSring {
    public static void main(String[] args) {

        String s = "baaabbabbb";
        System.out.println(getSemiAlternatingSubString(s));
    }

    public static int getSemiAlternatingSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int aCount = 0;
        int bCount = 0;
        int maxLen = 0;

        while (right < s.length()) {
            if (s.charAt(right) == 'a') {
                aCount++;
                bCount = 0;
            }

            if (s.charAt(right) == 'b') {
                bCount++;
                aCount = 0;
            }

            right++;

            //[left..right)
            if (aCount < 3 && bCount < 3) {
                maxLen = Math.max(maxLen, right - left);
            } else {
                if (aCount == 3) {
                    aCount = 2;
                }

                if (bCount == 3) {
                    bCount = 2;
                }

                left = right - 2;
            }
        }
        return maxLen;
    }
}
