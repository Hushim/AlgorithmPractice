import java.util.HashMap;
import java.util.Map;

public class MinStepsToGetStringWithout3ConsecutiveLetters {
    public static void main(String[] args) {



        String test2 = "baaabbaabbba";
        System.out.println(getMinStepsToGetStringWithout3ConsecutiveLettersint(test2));
    }

    public static int getMinStepsToGetStringWithout3ConsecutiveLettersint(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int countA = 0;
        int countB = 0;
        int steps = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countA++;
                countB = 0;
            } else {
                countB++;
                countA = 0;
            }

            if (countA == 3 || countB == 3) {
                steps++;
                countA = 0;
                countB = 0;
            }
        }

        return steps;
    }
}
