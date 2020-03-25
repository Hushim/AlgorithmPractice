import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestInteger {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -4 };
        System.out.println(getLargestInteger(arr));
    }

    public static int getLargestInteger(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(Math.abs(num))) {
                max = Math.max(max, Math.abs(num));
            }
        }
        return max;
    }
}
