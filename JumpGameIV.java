import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Deque<Integer> bfs = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        bfs.add(0);
        visited[0] = true;
        int target = arr.length - 1;
        int step = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int curI = bfs.poll();
                if (curI == arr.length - 1) return step;
                if (curI - 1 >= 0 && !visited[curI - 1]) {
                    bfs.add(curI - 1);
                    visited[curI - 1] = true;
                }
                if (curI + 1 < arr.length && !visited[curI + 1]) {
                    bfs.add(curI + 1);
                    visited[curI + 1] = true;
                }
                List<Integer> list = graph.remove(arr[curI]);
                if (list == null) continue;
                for (int j : list) {
                    if (visited[j]) continue;
                    bfs.add(j);
                    visited[j] = true;
                }
            }
            step++;
        }
        return step;
    }
}
