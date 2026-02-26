import java.util.Stack;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjancency = new int[numCourses][];  // i - для чего, j - требования
        for (int i = 0; i < numCourses; i++) adjancency[i] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int y = prerequisites[i][0];
            int x = prerequisites[i][1];
            if (y == x) return false;
            adjancency[y][x] = 1;
        }
        int[] status = new int[numCourses];  // 0 - не посещена, 1 - в процессе, 2 - посещена
        Stack<Integer> dfs = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            status[i] = 1;
            for (int j = 0; j < numCourses; j++) {
                if (adjancency[i][j] == 1 && status[j] == 0) {
                    dfs.push(j);
                    status[j] = 1;
                    if (!DFSReccursive(numCourses, dfs, adjancency, status)) return false;
                }
            }
            status[i] = 2;
        }
        return true;
    }

    private boolean DFSReccursive(int numCourses, Stack<Integer> dfs, int[][] adjancency, int[] status) {
        while (!dfs.isEmpty()) {
            int cur = dfs.peek();
            for (int k = 0; k < numCourses; k++) {
                if (cur == k) continue;
                if (adjancency[cur][k] == 1) {
                    switch (status[k]) {
                        case 0 -> {
                            dfs.push(k);
                            status[k] = 1;
                            if (!DFSReccursive(numCourses, dfs, adjancency, status)) return false;
                        }
                        case 1 -> {
                            return false;
                        }
                    }
                }
            }
            status[cur] = 2;
            if (!dfs.isEmpty()) dfs.pop();
        }
        return true;
    }
}
