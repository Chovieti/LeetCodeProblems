import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Deque<Node> bfs = new ArrayDeque<>();
        bfs.add(node);
        while (!bfs.isEmpty()) {
            Node oldNode = bfs.pop();
            if (visited.contains(oldNode.val)) continue;
            Node curNode = new Node(oldNode.val);
            graph.computeIfAbsent(curNode.val, k -> curNode);
            for (Node n : oldNode.neighbors) {
                bfs.add(n);
                graph.computeIfAbsent(n.val, k -> new Node(n.val));
                Node newNode = graph.get(n.val);
                graph.computeIfAbsent(curNode.val, k -> curNode).neighbors.add(newNode);
            }
            visited.add(oldNode.val);
        }
        return graph.get(1);
    }
}
