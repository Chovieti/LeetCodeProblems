public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = nums.length, min = Integer.MAX_VALUE;
        int left = 0, right = l - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int midRight = (mid + l + 1) % l, midLeft = (mid + l - 1) % l;
            if (nums[midRight] > nums[mid] && nums[midLeft] > nums[mid]) return nums[mid];
            if (nums[midRight] < nums[mid]) return nums[midRight];
            min = Math.min(min, nums[mid]);

            if (nums[left] > nums[right] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
