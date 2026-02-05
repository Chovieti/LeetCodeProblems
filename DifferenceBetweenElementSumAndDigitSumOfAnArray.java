public class DifferenceBetweenElementSumAndDigitSumOfAnArray {
    public int differenceOfSum(int[] nums) {
        int elemSum = 0, digitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            elemSum += cur;
            digitSum += (cur % 10);
            while (cur >= 10) {
                cur /= 10;
                digitSum += (cur % 10);
            }
        }
        return Math.abs(elemSum - digitSum);
    }
}
