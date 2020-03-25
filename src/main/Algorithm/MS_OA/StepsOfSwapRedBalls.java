import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepsOfSwapRedBalls {
    public static void main(String[] args) {


        String s = "WWwWRWWWRWR";
        System.out.println(getStepsOfSwapRedBalls(s));
    }

    public static long getStepsOfSwapRedBalls(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        List<Integer> redBallIndexes = getRedBallsIndexes(s);

        long minSwaps = 0;
        int size = redBallIndexes.size();
        int mid = size / 2;

        for (int i = 0; i < size; i++) {
            minSwaps += (Math.abs(redBallIndexes.get(mid) - redBallIndexes.get(i)) - Math.abs(mid - i));
            if (minSwaps > Math.pow(10, 9)) {
                return -1;
            }
        }
        return minSwaps;

    }

    private static List<Integer> getRedBallsIndexes(String s) {
        List<Integer> redBallIndexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                redBallIndexes.add(i);
            }
        }
        return redBallIndexes;
    }
}
