public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int res = colors.length - 1;
        if (colors[0] != colors[res]) return res;
        int curL = colors[0], curR = colors[res];
        int l = 0, r = colors.length - 1;
        while (colors[l] == curL || colors[r] == curR) {
            if (colors[l] == curL) l++;
            if (colors[r] == curR) r--;
        }
        res -= Math.min(l, res - r);
        return res;
    }
}
