import java.util.*;

public class LargestNumberNumTimes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 2, 2,  3, -1, 5, -1};
        System.out.println(getLargestNumberNumTimes(arr));
    }

    public static int getLargestNumberNumTimes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> numToCountsMap = new HashMap<>();
        for (int num : arr) {
            if (num <= 0) {
                continue;
            }

            numToCountsMap.merge(num, 1, (pre, cur) -> (pre + cur));
        }

        int ans = arr[0];
        for (Map.Entry<Integer, Integer> numToCounts : numToCountsMap.entrySet()) {
            int key = numToCounts.getKey();
            int value = numToCounts.getValue();
            if (key == value && key > ans) {
                ans = key;
            }
        }
        return ans;
    }
}
