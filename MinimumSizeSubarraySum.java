public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] < target) continue;
            int search = binarySearch(target, i, pref);
            result = Math.min(result, ((search == -1) ? i + 1 : i - search));
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }

    private int binarySearch(int target, int right, int[] pref) {
        int cur = pref[right];
        int left = 0;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = cur - pref[mid];
            if (tmp == target){
                return mid;
            } else if (tmp > target) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
