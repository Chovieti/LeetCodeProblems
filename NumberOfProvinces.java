import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberOfProvinces {
    private int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) union(i, j);
            }
        }
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) unique.add(find(i));
        return unique.size();
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) parent[rootX] = rootY;
    }
}
