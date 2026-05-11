import java.util.*;

public class FinIfPathExistsInGraph {
    int[] root;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;
        Map<Integer, List<Integer>> adj = new HashMap<>(n);
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            union(a, b);
        }
        return connect(source, destination);
    }

    private int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        root[rootA] = rootB;
    }

    private boolean connect(int a, int b) {
        return find(a) == find(b);
    }
}
