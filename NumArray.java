public class NumArray {
    private final int[] nums;
    private final int[] prefix;
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
            this.prefix[i] = (i == 0) ? nums[i] : nums[i] + prefix[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right] - (left == 0 ? 0 : prefix[left - 1]);
    }
}
