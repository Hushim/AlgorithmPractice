import java.util.HashMap;
import java.util.Map;

public class PlaneSeatsReservation {

    static Map<Character, Integer> seatNumToPosition = new HashMap<>();
    static {
        seatNumToPosition.put('A', 0);
        seatNumToPosition.put('B', 1);
        seatNumToPosition.put('C', 2);
        seatNumToPosition.put('D', 3);
        seatNumToPosition.put('E', 4);
        seatNumToPosition.put('F', 5);
        seatNumToPosition.put('G', 6);
        seatNumToPosition.put('H', 7);
        seatNumToPosition.put('J', 8);
        seatNumToPosition.put('K', 9);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 6, 5, 9, 7};
        int[] arr2 = {4, 3, 2, 6, 1};
        int[] arr = {2, 1, 6, 3, 7};
        System.out.println(getNumOfSeats(2, "1A 1D 1J 2J 2A 2D 2F"));
    }

    public static int getNumOfSeats(int N, String s) {

        int NUM_OF_SEATS_PER_ROW = 10;
        int NUM_OF_FAMILY = 4;

        //No reservations
        if (s == null || s.length() == 0) {
            return N * 2;
        }

        boolean[][] seatsMap = new boolean[N][NUM_OF_SEATS_PER_ROW]; //for the skipped I
        String[] reservedSeats = s.split(" ");
        for (String seat : reservedSeats) {
            int row = Integer.parseInt(seat.substring(0, 1)) - 1;
            int col = seatNumToPosition.getOrDefault(seat.charAt(1), -1);

            if (row >= 0 && row < N && col >= 0 && col < NUM_OF_SEATS_PER_ROW) {
                seatsMap[row][col] = true;
            }
        }

        int availableFamilySeats = 0;
        for (boolean[] row : seatsMap) {
            availableFamilySeats += getAvailableSeatsPerRow(row);
        }
        return availableFamilySeats;
    }

    private static int getAvailableSeatsPerRow(boolean[] row) {
        int availableFamilySeats = 0;
        //left
        if (!row[seatNumToPosition.get('B')]
                && !row[seatNumToPosition.get('C')]
                && !row[seatNumToPosition.get('D')]
                && !row[seatNumToPosition.get('E')]) {
            availableFamilySeats++;
        }

        //right
        if (!row[seatNumToPosition.get('F')]
                && !row[seatNumToPosition.get('G')]
                && !row[seatNumToPosition.get('H')]
                && !row[seatNumToPosition.get('J')]) {
            availableFamilySeats++;
        }

        //middle
        if (availableFamilySeats == 0
                && !row[seatNumToPosition.get('D')]
                && !row[seatNumToPosition.get('E')]
                && !row[seatNumToPosition.get('F')]
                && !row[seatNumToPosition.get('G')]) {
            availableFamilySeats++;
        }
        return availableFamilySeats;
    }
}
