public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int pile : piles) maxSpeed = Math.max(maxSpeed, pile);
        if (piles.length == h) return maxSpeed;
        return binarySearch(piles, h, maxSpeed);
    }

    private int binarySearch(int[] piles, int h, int right) {
        int left = 1;
        int minSpeed = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (checkSpeed(piles, mid, h)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    private boolean checkSpeed(int[] piles, int speed, int h) {
        int time = 0;
        for (int i = 0; i < piles.length && time <= h; i++) {
            time += (piles[i] / speed) + ((piles[i] % speed == 0) ? 0 : 1);
        }
        return time <= h;
    }
}
