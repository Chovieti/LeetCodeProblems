import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<Integer> bfs = new ArrayDeque<>();
        int n = wordList.size();
        boolean[] visited = new boolean[n];
        int destination = -1;
        for (int i = 0; i < n; i++) {
            if (beginWord.equals(wordList.get(i))) visited[i] = true;
            if (difStrings(beginWord, wordList.get(i))) {
                bfs.add(i);
                visited[i] = true;
            }
            if (destination == -1 && endWord.equals(wordList.get(i))) destination = i;
        }
        if (destination == -1) return 0;
        if (difStrings(beginWord, endWord)) return 2;
        Map<String, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;
                String a = wordList.get(i), b = wordList.get(j);
                if (difStrings(a, b)) {
                    adj.computeIfAbsent(a, k -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(b, k -> new ArrayList<>()).add(i);
                }
            }
        }
        int change = 2;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int cur = bfs.poll();
                String curWord = wordList.get(cur);
                List<Integer> neighbors = adj.get(curWord);
                for (int j = 0; j < neighbors.size(); j++) {
                    int index = neighbors.get(j);
                    if (index == destination) return change + 1;
                    if (visited[index]) continue;
                    bfs.add(index);
                    visited[index] = true;
                }
            }
            change++;
        }
        return 0;
    }

    private boolean difStrings(String a, String b) {
        int dif = 0, l = a.length();
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) dif++;
        }
        return dif == 1;
    }
}
