import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestEqualElementQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>(queries.length);

        Map<Integer, List<Integer>> heap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (heap.containsKey(nums[i])) {
                heap.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                heap.put(nums[i], list);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int curRes = -1;
            int number = nums[queries[i]];
            if (heap.containsKey(number) && heap.get(number).size() > 1) {
                curRes = calc(heap.get(number), binSeacrh(heap.get(number), queries[i]), nums.length);
            }
            result.add(curRes);
        }

        return result;
    }

    private int calc(List<Integer> nums, int ind, int N) {
        int n = nums.size();

        int leftDir, rightDir;
        if (ind - 1 < 0) {
            int leftInd = nums.get((ind - 1 + n) % n);
            leftDir = nums.get(ind) + N - leftInd;
        } else {
            leftDir = nums.get(ind) - nums.get(ind - 1);
        }
        if (ind + 1 >= n) {
            int rightInd = nums.get((ind + 1) % n);
            rightDir = rightInd + N - nums.get(ind);
        } else {
            rightDir = nums.get(ind + 1) - nums.get(ind);
        }
        int res = Math.min(leftDir, rightDir);
        return res;
    }

    private int binSeacrh(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cur = nums.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
