import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        backtrack(result, new ArrayList<>(), 0, candidates, target);
        return result.stream().toList();
    }

    private void backtrack(Set<List<Integer>> result, List<Integer> temp,
                           int index, int[] candidates, int target) {
        int curSum = 0;
        for (int i = 0; i < temp.size(); i++) curSum += temp.get(i);
        if (curSum > target) return;
        if (curSum == target) {
            Collections.sort(temp);
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(result, temp, i, candidates, target);
            temp.removeLast();
        }
    }
}
