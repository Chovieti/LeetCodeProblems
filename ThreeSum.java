import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<List<Integer>, Integer> result = new HashMap<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            int x = nums[i];
            for (int j = i - 1; j > 0; j--) {
                if (j < i - 1 && nums[j] == nums[j + 1]) continue;
                int y = nums[j];
                if (x + y > 1e5 || x + y + nums[0] > 0) continue;
                int k = binarySearch(nums, j - 1, (x + y));
                if (k == -1) continue;
                List<Integer> array = new ArrayList<>();
                array.add(x);
                array.add(y);
                array.add(nums[k]);
                result.put(array, 0);
            }
        }
        return new ArrayList<>(result.keySet());
    }

    private int binarySearch(int[] nums, int right, int target) {
        int res = -1;
        int left = 0;
        int mid = right / 2;
        while (left <= right) {
            if (nums[mid] + target == 0) {
                return mid;
            } else if (nums[mid] + target < 0) {
                left = mid + 1;
            } else if (nums[mid] + target > 0) {
                right = mid - 1;
            }
            mid = (right + left) / 2;
        }
        return -1;
    }
}
