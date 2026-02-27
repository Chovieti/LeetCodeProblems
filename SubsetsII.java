import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return new ArrayList<>(result);
    }

    private void backtrack(Set<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        result.add(new ArrayList<>(temp.stream().sorted().collect(Collectors.toList())));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, temp, i + 1, nums);
            temp.removeLast();
        }
    }
}
