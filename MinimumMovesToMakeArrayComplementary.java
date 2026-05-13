public class MinimumMovesToMakeArrayComplementary {
    public int minMoves(int[] nums, int limit) {
        int[] total = new int[2 * limit + 2];
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            total[2] += 2;
            total[2 * limit + 1] -= 2;

            total[Math.min(nums[l], nums[r]) + 1] -= 1;
            total[Math.max(nums[l], nums[r]) + limit + 1] += 1;

            total[nums[l] + nums[r]] -= 1;
            total[nums[l] + nums[r] + 1] += 1;
        }
        int pref = total[2];
        int result = pref;
        for (int i = 3; i <= 2 * limit; i++) {
            pref += total[i];
            result = Math.min(result, pref);
        }
        return result;
    }
}
