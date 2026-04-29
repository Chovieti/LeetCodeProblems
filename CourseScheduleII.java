import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            graph.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }
        int[] state = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            if (!dfs(graph, state, i, result)) return new int[0];
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] state, int node, List<Integer> result) {
        if (state[node] == 1) return false;
        if (state[node] == 2) return true;
        state[node] = 1;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!dfs(graph, state, neighbor, result)) return false;
            }
        }
        state[node] = 2;
        result.add(node);
        return true;
    }
}
