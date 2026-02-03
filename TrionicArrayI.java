public class TrionicArrayI {
    public boolean iTrionic(int[] nums) {
        boolean increase = true, firstDecrease = false;
        for (int i = 1, prev = nums[0], point = nums[0]; i < nums.length; i++) {
            if (prev == nums[i]) return false;
            if (increase) {
                if (nums[i] < prev) {
                    if ((nums[i - 1] == point && !firstDecrease) || firstDecrease) return false;
                    point = nums[i];
                    increase = false;
                    firstDecrease = true;
                }
            } else if (!increase) {
                if (nums[i] > prev) {
                    point = nums[i];
                    increase = true;
                }
            }
            prev = nums[i];
        }
        if (!firstDecrease || !increase) return false;
        return true;
    }
}
