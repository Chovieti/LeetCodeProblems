public class MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums2.length - 1;
        if (nums1[0] <= nums2[n]) return n;

        int result = 0;
        for (int i = 0, j = 0; i < nums1.length; i++) {
            int target = nums1[i];
            if (target > nums2[Math.min(i, n)]) continue;
            j = Math.max(i, binarySearch(nums2, target, j));
            result = Math.max(result, j - i);
        }
        return result;
    }

    private int binarySearch(int[] nums, int target, int left) {
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                left = mid + 1;
                result = Math.max(result, mid);
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return result;
    }
}
