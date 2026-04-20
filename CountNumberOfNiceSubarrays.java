import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] % 2 == 0) ? 0 : 1;
            if (map.containsKey(count - k)) {
                res += map.get(count - k);
            }
            map.merge(count, 1, Integer::sum);
        }
        return res;
    }
}
