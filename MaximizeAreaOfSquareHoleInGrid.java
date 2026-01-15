import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = 0, maxW = 0;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        for (int i = 0, prev = 0, currentH = 0; i < hBars.length; i++) {
            currentH = (hBars[i] != n + 2 && hBars[i] == prev + 1) ? currentH + 1 : 1;
            prev = hBars[i];
            maxH = Math.max(maxH, currentH);
        }
        for (int i = 0, prev = 0, currentW = 0; i < vBars.length; i++) {
            currentW = (vBars[i] != m + 2 && vBars[i] == prev + 1) ? currentW + 1 : 1;
            prev = vBars[i];
            maxW = Math.max(maxW, currentW);
        }
        return ((Math.min(maxH, maxW) + 1) * (Math.min(maxH, maxW) + 1));
    }
}
