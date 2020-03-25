public class MinDeletionToObtainRightFormat {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 6, 5, 9, 7};
        int[] arr2 = {4, 3, 2, 6, 1};
        int[] arr = {2, 1, 6, 3, 7};
        String s = "";
        System.out.println(getMinDeletionNum(s));
    }

    public static int getMinDeletionNum (String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int leftB = 0;  //number of B at [0.. i]
        int rightA = 0; //number if A at (i .. length - 1]


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                rightA++;
            }
        }

        int minDeletion = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                leftB++;
            } else {
                rightA--;
            }
            minDeletion = Math.min(minDeletion, leftB + rightA);

        }

        return minDeletion;
    }
}
