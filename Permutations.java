import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, boolean[] used, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(result, temp, used, nums);
            temp.removeLast();
            used[i] = false;
        }
    }
}
