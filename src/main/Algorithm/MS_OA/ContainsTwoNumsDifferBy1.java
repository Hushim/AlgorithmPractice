import java.util.HashSet;
import java.util.Set;

class ContainsTwoNumsDifferBy1 {
    public static void main(String[] args) {

        int[] A = {5, 5, 6};
        System.out.println(solution(A));
    }

    public static boolean solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length <= 1) {
            return false;
        }

        Set<Integer> containedNums = new HashSet<>();
        for (int num : A) {
            if (containedNums.contains(num - 1) || containedNums.contains(num + 1)) {
                return true;
            } else {
                containedNums.add(num);
            }
        }
        return false;
    }
}
