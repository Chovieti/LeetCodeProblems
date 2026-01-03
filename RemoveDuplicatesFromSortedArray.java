public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int countUniq = 1;
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[j] == nums[i]) continue;
            nums[++j] = nums[i];
            countUniq++;
        }
        return countUniq;
    }
}
