import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = s.length(), n = words[0].length(), k = words.length;
        if (m < n * k) return new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < k; i++) dictionary.merge(words[i], 1, Integer::sum);
        String[] allWords = new String[m - n + 1];
        for (int i = 0; i + n <= m; i++) allWords[i] = s.substring(i, i + n);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + (n * k) <= m; i++) {
            boolean correct = true;
            Map<String, Integer> window = new HashMap<>();
            for (int j = 0; j < k; j++) {
                String word = allWords[i + (n * j)];
                if (!dictionary.containsKey(word)) {
                    correct = false;
                    break;
                }
                int count = window.merge(word, 1, Integer::sum);
                if (count > dictionary.get(word)) {
                    correct = false;
                    break;
                }
            }
            if (!correct) continue;
            result.add(i);
        }
        return result;
    }
}
