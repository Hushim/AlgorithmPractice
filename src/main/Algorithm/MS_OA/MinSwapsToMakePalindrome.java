import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinSwapsToMakePalindrome {

    public static void main(String[] args) {

        String s = "aaabb";
        System.out.println(getMinSwaps(s));
    }
    /**
     * Algorithm:
     *     1. First check the given string is a jumbled/shuffled palindrome or not.
     *     2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start iterating.
     *     3. If chars at both the pointers are same then just shrink the window (increase the p1 and decrease the p2).
     *     4. or Else
     *          a. find the matching pair and swap the char to p2 index (increase swap count while swapping) and finally shrink the window.
     *          b. if not found just swap once with adjacent index and increase the swap count (do not shrink the window here)
     *     5. Print the Swap Count
     *
     * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration * O(n) for checking and swapping ] so => O(n^2)
     * Space Complexity: O(n)
     *
     */
    public static int getMinSwaps(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        if (!isPossiblePalindrome(s)) {
            return -1;
        }

        char[] charArr = s.toCharArray();
        int minSwaps = 0;
        int left = 0;
        int right = charArr.length - 1;
        while (left < right) {
            if (charArr[left] == charArr[right]) {
                left++;
                right--;
            } else {
                int toSwap = right;
                while (toSwap > left && charArr[toSwap] != charArr[left]) {
                    toSwap--;
                }

                if (toSwap == left) {
                    swap(charArr, left, left + 1);//charArr[left] may be the middle character
                    minSwaps++;
                } else {
                    while (toSwap < right) {// swap the matching character until it reaches right so that charArr[left] == charArr[right];
                        swap(charArr, toSwap, toSwap + 1);
                        toSwap++;
                        minSwaps++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return minSwaps;
    }

    private static void swap(char[] s, int index1, int index2) {
        char tmp = s[index1];
        s[index1] = s[index2];
        s[index2] = tmp;
    }

    private static boolean isPossiblePalindrome(String s) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                characters.remove(c);
            } else {
                characters.add(c);
            }
        }
        return characters.size() <= 1;
    }
}
