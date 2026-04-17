import java.util.HashMap;
import java.util.Map;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = Math.min(result, Math.abs(i - map.get(nums[i])));
            }
            int reverse = reverse(nums[i]);
            map.put(reverse, i);
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private int reverse(int n) {
        boolean first = true;
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            n /= 10;
            if (tmp == 0 && first) continue;
            first = false;
            res = (res * 10) + tmp;
        }
        return res;
    }
}
