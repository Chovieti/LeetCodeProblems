public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = right / 2;
        while (left <= right) {
            if (nums[mid] == target) return mid;
            if (left == right) break;
            if (nums[mid] > target) {
                if (nums[left] > target && nums[left] <= nums[mid]) {
                    left = mid + 1;
                    mid = (right + left) / 2;
                } else {
                    right = mid;
                    mid = (right + left) / 2;
                }
            } else if (nums[mid] < target) {
                if (nums[right] < target && nums[right] >= nums[mid]) {
                    right = mid;
                    mid = (right + left) / 2;
                } else {
                    left = mid + 1;
                    mid = (right + left) / 2;
                }
            }
        }
        return -1;
    }
}
