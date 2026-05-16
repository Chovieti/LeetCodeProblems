public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = nums.length, min = Integer.MAX_VALUE;
        int left = 0, right = l - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int ln = nums[left], mn = nums[mid], rn = nums[right];
            min = Math.min(mn, min);
            if (ln == mn && mn == rn) {
                left++;
                right--;
            } else if (mn > rn) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }
}
