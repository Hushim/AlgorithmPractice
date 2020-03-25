import java.util.HashMap;
import java.util.Map;

public class MaxNetworkRanks {
    public static void main(String[] args) {

        int[] a = {1, 2, 4, 5};
        int[] b = {2, 3, 5, 6};
        System.out.println(getMaxNetworkRanks(a, b, 4));
    }

    public static int getMaxNetworkRanks(int[] A, int[] B, int N) {
        if (A == null || B == null || A.length != B.length) {
            return 0;
        }

        Map<Integer, Integer> cityToNumOfRoads = new HashMap<>();
        for (int i = 0; i < N; i++) {
            cityToNumOfRoads.merge(A[i], 1, (pre, cur) -> pre + cur);
            cityToNumOfRoads.merge(B[i], 1, (pre, cur) -> pre + cur);
        }

        int maxRank = 0;
        for (int i = 0; i < N; i++) {
            maxRank = Math.max(maxRank, cityToNumOfRoads.get(A[i]) + cityToNumOfRoads.get(B[i]) - 1);
        }

        return maxRank;

    }
}
