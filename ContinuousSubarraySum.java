import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = ((sum % k) + k) % k;
            if (map.containsKey(mod) && i - map.get(mod) >= 2) return true;
            if (!map.containsKey(mod)) map.put(mod, i);
        }
        return false;
    }
}
