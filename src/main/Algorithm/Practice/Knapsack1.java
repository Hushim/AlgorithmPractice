public class Knapsack1 {

    public static void main(String[] args) {
        Knapsack1 knapsack1 = new Knapsack1();
        int[] w = {1, 1, 2, 2};
        int[] v = {1, 2, 4, 5};
        int W = 4;
        System.out.println(knapsack1.findMaxValue(v, w , W));
    }

    public int findMaxValue(int[] itemValues, int[] itemWeights, int maxWidget) {
        if (itemValues == null || itemValues.length == 0 || itemWeights == null || itemWeights.length == 0 || maxWidget == 0) {
            return 0;
        }

        //dp[i][j]: max value for the first ith items that their total weight is equal or less than j
        int[][] dp = new int[itemValues.length + 1][maxWidget + 1];

        for (int i = 0; i <= itemWeights.length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= itemValues.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < itemValues.length; i++) {
            for (int j = 1; j <= maxWidget; j++) {
                if (j - itemWeights[i] >= 0) {
                    //the ith value in itemValues mean the first (i + 1)th item in dp[i][j]
                    dp[i + 1][j] = Math.max(dp[i][j - itemWeights[i]] + itemValues[i], dp[i][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[itemValues.length][maxWidget];
    }
}
