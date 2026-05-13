import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needed = new HashMap<>();
        long correct = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needed.merge(c, 1, Integer::sum);
            correct |= 1L << (c - 'A');
        }
        int[] min = new int[]{0, Integer.MAX_VALUE};
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // Двигаем пока не найдем начало
            if (l == r && !needed.containsKey(c)) {
                l++;
                continue;
            }
            // Добавляем в окно
            if (needed.containsKey(c)) {
                if (needed.merge(c, -1, Integer::sum) <= 0) correct &= ~(1L << (c - 'A'));
            }
            // Если получили окно, то сокращаем при возможности, а затем смотрим его размеры
            if (correct == 0L) {
                while (true) {
                    char last = s.charAt(l);
                    if (needed.containsKey(last)) {
                        if (needed.get(last) == 0) break;
                        needed.merge(last, 1, Integer::sum);
                    }
                    l++;
                }
                if (min[1] - min[0] > r - l) {
                    min[0] = l;
                    min[1] = r;
                }
            }
        }
        return min[1] == Integer.MAX_VALUE ? "" : s.substring(min[0], min[1] + 1);
    }
}
