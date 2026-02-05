public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            int index = i + nums[i];
            while (index >= l) {
                index -= l;
            }
            while (index < 0) {
                index += l;
            }
            result[i] = nums[index];
        }
        return result;
    }
}
