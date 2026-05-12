import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int min = tasks[0][1];
        int cur = tasks[0][1] - tasks[0][0];
        for (int i = 1; i < tasks.length; i++) {
            int div = cur - tasks[i][1];
            if (div < 0) {
                cur -= div;
                min -= div;
            }
            cur -= tasks[i][0];
        }
        return min;
    }
}
