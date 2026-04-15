import java.util.HashSet;
import java.util.Set;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.contains(-nums[i])) res = Math.max(res, Math.abs(nums[i]));
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
