public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int l = bookings[i][0];
            int r = bookings[i][1];
            int s = bookings[i][2];
            for (; l <= r; l++) {
                res[l] += s;
            }
        }
        return res;
    }
}
