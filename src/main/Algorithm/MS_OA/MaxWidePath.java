import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxWidePath {


    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 6, 5, 9, 7};
        int[] arr2 = {4, 3, 2, 6, 1};
        int[] arr = {6, 10, 1, 4, 3};
        System.out.println(getMaxWidePath(arr, new int[0]));
    }

    public static int getMaxWidePath(int[] X, int [] y) {
        if (X == null || X.length == 0) {
            return 0;
        }

        int widestPath = 0;
        Arrays.sort(X);
        for (int i = 0; i < X.length - 1; i++) {
            widestPath = Math.max(widestPath, X[i + 1] - X[i]);
        }

        return widestPath;
    }

}
