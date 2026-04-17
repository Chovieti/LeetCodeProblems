import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> tmpRes = new ArrayList<>();
        tmpRes.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int j = 0;
            while (true) {
                int[] tmp = tmpRes.get(j);
                if (cur[1] < tmp[0]) {
                    tmpRes.add(j, cur);
                    break;
                } else if (cur[0] > tmp[1]) {
                    j++;
                    if (j >= tmpRes.size()) {
                        tmpRes.add(cur);
                        break;
                    }
                } else {
                    tmpRes.remove(j);
                    int left = Math.min(tmp[0], cur[0]);
                    int right = Math.max(tmp[1], cur[1]);
                    cur[0] = left;
                    cur[1] = right;
                    if (j >= tmpRes.size()) {
                        tmpRes.add(cur);
                        break;
                    }
                }
            }
        }
        int[][] res = new int[tmpRes.size()][2];
        for (int i = 0; i < tmpRes.size(); i++) {
            res[i] = tmpRes.get(i);
        }
        return res;
    }
}
