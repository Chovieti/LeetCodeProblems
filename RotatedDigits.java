public class RotatedDigits {
    public int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (checkDigit(i) ? 1 : 0);
        }
        return dp[n];
    }

    private boolean checkDigit(int n) {
        int changed = 0;
        while (n > 0) {
            switch (n % 10) {
                case 0, 1, 8 -> {}
                case 2, 5, 6, 9 -> changed++;
                default -> {
                    return false;
                }
            }
            n /= 10;
        }
        return changed > 0;
    }
}
