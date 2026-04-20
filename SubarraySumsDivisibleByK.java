import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = ((sum % k) + k) % k;
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.merge(mod, 1, Integer::sum);
        }
        return count;
    }
}
