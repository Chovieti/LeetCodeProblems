import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, temp, i + 1, nums);
            temp.removeLast();
        }
    }
}
