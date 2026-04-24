import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pattern = new HashMap<>();
        int k = p.length();
        for (int i = 0; i < k; i++) {
            pattern.merge(p.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            window.merge(s.charAt(r), 1, Integer::sum);
            if (r + 1 < k) continue;
            if (window.equals(pattern)) result.add(l);
            window.merge(s.charAt(l), -1, Integer::sum);
            if (window.get(s.charAt(l)) == 0) window.remove(s.charAt(l));
            l++;
        }
        return result;
    }
}
