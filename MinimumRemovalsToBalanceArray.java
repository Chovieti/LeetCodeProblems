import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, tmpRes = 0;
        while ((long) nums[i] * k < nums[j]) {
            i++;
            tmpRes++;
        }
        int result = tmpRes;
        for (; i <= j && i >= 0; j--, i--) {
            while (j < nums.length && (long) nums[i] * k >= nums[j]) j++;
            j--;
            result = Math.min(result, (i + nums.length - 1 - j));
        }
        return result;
    }
}
