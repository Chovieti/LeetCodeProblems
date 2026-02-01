public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public int minumumCost(int[] nums) {
        int start = nums[0], mid = nums[1], last = nums[2];
        for (int i = 3; i < nums.length; i++) {
            if ((nums[i] + last <= mid + last) || (nums[i] + mid <= mid + last)) {
                mid = Math.min(mid, last);
                last = nums[i];
            }
        }
        return (start + mid + last);
    }
}
