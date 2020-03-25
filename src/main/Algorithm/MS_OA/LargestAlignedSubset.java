import java.util.*;

public class LargestAlignedSubset {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -3, -3, 5 ,6, 5, 5, 5, 5};
        int[] arr1 = {-3, -2, 1, 0, 8, 7, 1};
        int[] arr2 = {4, 7, 10, 6, 9};
        int[] res = getLargestAlignedSubset(arr, 3);
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static int[] getLargestAlignedSubset(int[] arr, int m) {
        if (arr == null || arr.length <= 1) {
            return new int[0];
        }

        Map<Integer, List<Integer>> remainderToPoints = new HashMap<>();
        for (int point : arr) {
            int remainder = point % m;
            if (remainderToPoints.containsKey(remainder)) {
                remainderToPoints.get(remainder).add(point);
            } else {
                List<Integer> points = new ArrayList<>();
                points.add(point);
                remainderToPoints.put(remainder, points);
            }
        }

        Optional<List<Integer>> largestAlignedSubset = remainderToPoints.entrySet().stream()
                .filter(entry -> entry.getKey() == 0 || entry.getValue().size() >= 2)
                .map(entry -> entry.getValue())
                .max(Comparator.comparing(List::size));

        if (!largestAlignedSubset.isPresent()) {
            return new int[0];
        } else {
            return largestAlignedSubset.get().stream().mapToInt(i -> i).toArray();
        }
    }
}
