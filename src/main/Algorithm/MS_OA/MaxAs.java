import java.util.Arrays;

public class MaxAs {


    public static void main(String[] args) {

//        String s1 = "a";
//        String s1 = "abaaa";
//        String s1 = "abaaa";abaaa
        String s = "abaabbbaaba";
        System.out.println(getMaxAs(s));
    }

    public static int getMaxAs(String s) {

        if (s == null || s.length() == 0) {
            return 2;
        }

        int countAs = 0; // count consecutive when reaching current position;
        int numOfInserts = 0;// num of "A"s we can insert when reaching current position.

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countAs++;
            } else {
                numOfInserts += 2 - countAs;
                countAs = 0;
            }

            if (countAs == 3) {
                return -1;
            }
        }

        if (s.charAt(s.length() - 1) == 'a') {
            numOfInserts += 2 - countAs;
        } else {
            numOfInserts += 2;
        }
        return numOfInserts;
    }

}
