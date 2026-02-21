import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefix = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = i == 0 ? nums[i] : nums[i] + prefix[i - 1];
            if (prefix[i] == k) {
                count++;
            }
            if (map.containsKey(prefix[i] - k)) {
                count += map.get(prefix[i] - k).size();
            }
            if (!map.containsKey(prefix[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(prefix[i], list);
            } else {
                List<Integer> list = map.get(prefix[i]);
                list.add(i);
            }
        }
        return count;
    }
}
