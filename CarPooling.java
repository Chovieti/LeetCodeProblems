public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pref = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                pref[j] += trips[i][0];
                if (pref[j] > capacity) return false;
            }
        }
        return true;
    }
}
