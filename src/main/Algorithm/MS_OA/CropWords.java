public class CropWords {

    public static void main(String[] args) {
        System.out.println(cropWords("codility We test coders", 14));
        System.out.println(cropWords(" co de my", 5));
        System.out.println(cropWords(" co de my", 7));
        System.out.println(cropWords("   ", 2));
        System.out.println(cropWords("   re", 2));
        System.out.println(cropWords(" c ", 3));
        System.out.println(cropWords(" c d  ", 5));
        System.out.println(cropWords("co de my", 5));
        System.out.println(cropWords("Word", 4));
        System.out.println(cropWords("codility We test coders", 23));
        System.out.println(cropWords("withOutSpaces", 14));
        System.out.println(cropWords("", 14));
        System.out.println(cropWords("Separatedby hyphens", 14));
        System.out.println(cropWords("      Codility We test coders     ", 14));
        System.out.println(cropWords("      Codility We test coders     ", 10));
    }

    public static String cropWords(String words, int K) {
        if (words == null || words.length() == 0) {
            return words;
        }

        int len = words.length();

        //Case 1: K >= length of words, return the words itself without tailing spaces
        if (K >= len) {
            int tail = len - 1;
            while (words.charAt(tail) == ' ') {
                tail--;
            }
            return words.substring(0, tail + 1);
        }


        //Case 2: if words.charAt(K) == ' ', just keep words[0..K-1], e.g: "XXXX| XX"
        if (words.charAt(K) == ' ') {
            return words.substring(0, K);
        }


        int lastSpace = -1;
        for (int i = 0 ; i < K && i < words.length(); i++) {
            if (words.charAt(i) == ' ') {
                lastSpace = i;
            }
        }

        //Case3: No space is detected when reaching K, the K stops within the first word
        // e.g "XXXX|X XX"
        if (lastSpace == -1) {
            return "";
        }

        //Case4: general case, find last space position and return the substring without tailing spaces.
        while (lastSpace >= 0 && words.charAt(lastSpace) == ' ') {
            lastSpace--;
        }

        return words.substring(0, lastSpace + 1);
    }
}
