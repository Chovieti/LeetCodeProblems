import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> en : map.entrySet()) {
            if (en.getValue().size() < 3) continue;
            List<Integer> list = en.getValue();
            for (int i = 0; i < list.size() - 2; i++) {
                int x = list.get(i);
                for (int j = i + 1; j < list.size() - 1; j++) {
                    int y = list.get(j);
                    for (int k = j + 1; k < list.size(); k++) {
                        int z = list.get(k);
                        int tmpRes = Math.abs(x - y) + Math.abs(y - z) + Math.abs(z - x);
                        result = Math.min(result, tmpRes);
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
