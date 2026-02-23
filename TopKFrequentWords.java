import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) freq.merge(word, 1, Integer::sum);
        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            int cmp = Integer.compare(e1.getValue(), e2.getValue());
            return cmp != 0 ? cmp : e1.getKey().compareTo(e2.getKey());
        });
        for (Map.Entry<String, Integer> entry : freq.entrySet()) heap.add(entry);
        List<String> res = heap.stream()
                .sorted((e1, e2) -> {
                    int cmp = Integer.compare(e2.getValue(), e1.getValue());
                    return cmp != 0 ? cmp : e1.getKey().compareTo(e2.getKey());
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return res;
    }
}
