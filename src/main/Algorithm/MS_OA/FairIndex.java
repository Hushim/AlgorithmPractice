class FairIndex {
    public static void main(String[] args) {

        int[] A = {5, 5};
        int[] B = {5, 5};

        FairIndex fairIndex = new FairIndex();
        System.out.println(fairIndex.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        //corner case:
        if (A == null || A.length == 0 ||B == null || B.length == 0 || A.length != B.length) {
            return 0;
        }

        int numOfFairs = 0; // track the number of fair indexes
        int sumOfA = 0;
        int sumOfB = 0;
        for (int i =  0; i < A.length; i++) {
            sumOfA += A[i];
            sumOfB += B[i];
        }

        //if the sum is not equal or sum is not even, we can't split them to equal chunk.
        if (sumOfA != sumOfB || sumOfA % 2 != 0 || sumOfB % 2 != 0) {
            return 0;
        }

        int halfSumA = 0; // to track the sum of A[0.. k - 1] until it's half of the total sum of A
        int halfSumB = 0; // to track the sum of B[0.. k - 1] until it's half of the total sum of B

        //iterate from 0 to N-2 because each chunk can't be empty;
        for (int i = 0; i <= A.length - 2; i++) {
            halfSumA += A[i];
            halfSumB += B[i];

            if (2 * halfSumA == sumOfA && 2 * halfSumB == sumOfB) {
                numOfFairs++;
            }
        }

        return numOfFairs;
    }
}
