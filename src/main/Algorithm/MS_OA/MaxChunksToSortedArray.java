public class MaxChunksToSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 6, 5, 9, 7};
        int[] arr2 = {4, 3, 2, 6, 1};
        int[] arr = {2, 1, 6, 3, 7};
        System.out.println(getMaxChunksToSortedArray(arr));
    }

    public static int getMaxChunksToSortedArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = arr.length;
        int[] minRight = new int[len];
        minRight[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }

        int numOfSlices = 0;
        int maxLeft = arr[0];
        for (int i = 0; i < len; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);
            if (i == len - 1 || maxLeft <= minRight[i + 1]) {
                numOfSlices++;
            }
        }
        return numOfSlices;
    }
}
