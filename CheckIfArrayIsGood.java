public class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        boolean[] checked = new boolean[n];
        boolean doubleCheck = false;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur >= n || (cur < n - 1 && checked[cur])) return false;
            if (cur == n - 1 && checked[cur]) {
                if (doubleCheck) return false;
                doubleCheck = true;
            }
            checked[cur] = true;
        }
        return true;
    }
}
