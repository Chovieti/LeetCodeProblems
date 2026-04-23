import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistances {
    record Pair(int index, long pref) {}
    public long[] distance(int[] nums) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Pair> list = map.get(nums[i]);
                list.add(new Pair(i, list.get(list.size() - 1).pref + i));
            } else {
                List<Pair> list = new ArrayList<>(List.of(new Pair(i, (long) i)));
                map.put(nums[i], list);
            }
        }
        long[] result = new long[nums.length];
        if (nums.length == map.size()) return result;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]).size() > 1) {
                List<Pair> list = map.get(nums[i]);
                result[i] = calc(binSearch(i, list), list);
            }
        }
        return result;
    }

    private int binSearch(int target, List<Pair> list) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int cur = list.get(mid).index;
            if (cur == target) return mid;
            if (cur > target) {
                right = mid - 1;
            } else if (cur < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private long calc(int cur, List<Pair> list) {
        long result = 0L;
        result = Math.abs(cur == 0 ? 0 : ((long) cur * list.get(cur).index) - list.get(cur - 1).pref)
                + Math.abs(list.get(cur).index * (list.size() - cur - 1L) - (list.get(list.size() - 1).pref() - list.get(cur).pref));
        return result;
    }
}
