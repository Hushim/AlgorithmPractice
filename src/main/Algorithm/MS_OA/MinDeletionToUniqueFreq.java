import java.util.*;

public class MinDeletionToUniqueFreq {
    public static void main(String[] args) {
        String s = "llll";
        System.out.println(getMinDeletionToUniqueFreq(s));
    }

    public static long getMinDeletionToUniqueFreq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charToFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToFreq.merge(s.charAt(i), 1, (pre, cur) -> pre + cur);
        }

        int minDletions = 0;
        Set<Integer> uniqueFreqs = new HashSet<>();
        for (int freq : charToFreq.values()) {
            while (uniqueFreqs.contains(freq)) {
                freq--;
                minDletions++;
            }

            if (freq > 0) {
                uniqueFreqs.add(freq);
            }
        }

        return minDletions;
    }

}
