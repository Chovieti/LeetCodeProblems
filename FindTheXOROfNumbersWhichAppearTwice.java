import java.util.HashSet;
import java.util.Set;

public class FindTheXOROfNumbersWhichAppearTwice {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (set.contains(cur)) {
                result ^= cur;
            } else {
                set.add(cur);
            }
        }
        return result;
    }
}
