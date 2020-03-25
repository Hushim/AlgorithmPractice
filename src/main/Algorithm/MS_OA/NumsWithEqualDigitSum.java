import java.util.HashMap;
import java.util.Map;

public class NumsWithEqualDigitSum {
    public static void main(String[] args) {


        int[] test = {51, 71, 17, 42};
        int[] test1 = {51, 71, 17, 42};
        int[] test2 = {-42, 31, 60};
        System.out.println(getNumsWithEqualDigitSum(test2));
    }

    public static int getNumsWithEqualDigitSum(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxSum = -1;
        Map<Integer, Integer> digitSumToMaxNum = new HashMap<>();
        for (int num : A) {
            int digitSum = getDigitSum(num);
            if (digitSumToMaxNum.containsKey(digitSum)) {
                int maxNumForCurDigitSum = digitSumToMaxNum.get(digitSum);
                maxSum = Math.max(maxNumForCurDigitSum + num,  maxSum);
                digitSumToMaxNum.put(digitSum, Math.max(maxNumForCurDigitSum, num));
            } else {
                digitSumToMaxNum.put(digitSum, num);
            }
        }
        return maxSum;
    }

    private static int getDigitSum(int num) {
        num = Math.abs(num);
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }
}
