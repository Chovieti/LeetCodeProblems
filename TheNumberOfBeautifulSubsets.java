import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheNumberOfBeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        // Arrays.sort(nums);
        return backtrack(0, nums, k, 0, new HashMap<>());
    }

    private int backtrack(int result, int[] nums, int k, int index, Map<Integer, Integer> set) {
        for (int i = index; i < nums.length; i++) {
            if (!set.containsKey(nums[i] - k) && !set.containsKey(nums[i] + k)) {
                set.merge(nums[i], 1, Integer::sum);
                result = backtrack(++result, nums, k, i + 1, set);
                set.merge(nums[i], -1, Integer::sum);
                set.remove(nums[i], 0);
            }
        }
        return result;
    }
}
