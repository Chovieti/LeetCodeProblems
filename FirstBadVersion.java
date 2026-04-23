public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        int result = Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
}
