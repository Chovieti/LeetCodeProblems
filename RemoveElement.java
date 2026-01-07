public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[j++] = nums[i];
            result++;
        }
        return result;
    }
}
