public class MirrorDistanceOfAnInteger {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        boolean first = true;
        int res = 0;
        while (n % 10 == 0) n /= 10;
        while (n > 0) {
            int tmp = n % 10;
            n /= 10;
            if (tmp == 0) continue;
            res = (res * 10) + tmp;
        }
        return res;
    }
}
