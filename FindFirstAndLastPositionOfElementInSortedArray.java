public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = binarySearch(nums, target, true);
        if (result[0] != -1) result[1] = binarySearch(nums, target, false);
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean lowest) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (lowest && mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else if (!lowest && mid < nums.length - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
