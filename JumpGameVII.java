public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int[] prefix = new int[n];
        prefix[0] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                int left = Math.max(0, i - maxJump);
                int right = i - minJump;
                if (right >= 0 && (prefix[right] - (left > 0 ? prefix[left - 1] : 0)) > 0) dp[i] = true;
            }
            prefix[i] = prefix[i - 1] + (dp[i] ? 1 : 0);
        }

        return dp[n - 1];
    }
}
