import java.util.Arrays;

public class Piles {
    public static void main(String[] args) {

        int[] piles = {7, 5, 2, 2};

        System.out.println(getStepsOfPiles(piles));
    }

    public static int getStepsOfPiles(int[] piles) {
        if (piles == null || piles.length <= 1) {
            return 0;
        }

        Arrays.sort(piles);
        int distinctNum = 0; //Num of different height except the lowest one;
        int steps = 0;
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] == piles[i - 1]) {
                steps += distinctNum;
            } else {
                distinctNum++;
                steps += distinctNum;
            }
        }
        return steps;
    }
}
