import java.util.ArrayList;
import java.util.List;

public class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, prev = 0, k = 0; i < nums.length; i++) {
            prev = nums[i];
            if (prev > 0) {
                seen.add(0, prev);
                k = 0;
            } else {
                k++;
                ans.add(k > seen.size() ? -1 : seen.get(k - 1));
            }
        }
        return ans;
    }
}
