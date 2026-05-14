import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int n = firstList.length, m = secondList.length;
        int i = 0, j = 0;
        int[] first = null, second = null;
        while (i < n && j < m) {
            first = firstList[i];
            second = secondList[j];
            if (first[0] > second[1]) {
                j++;
                continue;
            } else if (second[0] > first[1]) {
                i++;
                continue;
            }
            result.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
            if (first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().toArray(int[][]::new);
    }
}
