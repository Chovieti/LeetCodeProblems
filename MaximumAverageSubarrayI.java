public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double res = (double) sum / k;
        for (int i = 1; i + k < nums.length; i++) {
            sum = sum - nums[i - 1] + nums[i + k];
            res = Math.max(res, ((double) sum / k));
        }
        return res;
    }
}
