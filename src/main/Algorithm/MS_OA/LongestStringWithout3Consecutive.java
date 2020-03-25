public class LongestStringWithout3Consecutive {
    public static void main(String[] args) {

        String s = "uuuuxaaaaxuuu";
        System.out.println(getLongestStringWithout3Consecutive(s));
    }

    public static String getLongestStringWithout3Consecutive(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        char pre = ' ';
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                count++;
            } else {
                pre = s.charAt(i);
                count = 1;
            }

            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();


    }
}
