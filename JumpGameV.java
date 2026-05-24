public class JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, dfs(i, arr, d, dp));
        return max;
    }

    private int dfs(int index, int[] arr, int d, int[] dp) {
        if (dp[index] != 0) return dp[index];
        int cur = arr[index];
        int max = 0;
        for (int i = index - 1; i >= index - d && i >= 0; i--) {
            if (arr[i] >= cur) break;
            max = Math.max(max, dfs(i, arr, d, dp));
        }
        for (int i = index + 1; i <= index + d && i < arr.length; i++) {
            if (arr[i] >= cur) break;
            max = Math.max(max, dfs(i, arr, d, dp));
        }
        return dp[index] = max + 1;
    }
}
