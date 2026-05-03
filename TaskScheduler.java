import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < tasks.length; i++) {
            map.merge(tasks[i], 1, Integer::sum);
            max = Math.max(max, map.get(tasks[i]));
        }
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) heap.add(entry.getValue());
        int result = 0, taskCycle = 0;
        while (!heap.isEmpty()) {
            if (heap.peek() == 1) break;
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i <= n && !heap.isEmpty(); i++) {
                int cur = heap.poll();
                if (cur - 1 == 0) continue;
                tmpList.add(cur - 1);
            }
            taskCycle++;
            heap.addAll(tmpList);
        }
        result = taskCycle * (n + 1) + heap.size();

        return Math.max(result, tasks.length);
    }
}
