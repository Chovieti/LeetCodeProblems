public class FindTheLongestSemiRepetitiveSubstring {
    public int longestSemiRepetitiveSubstring(String s) {
        int res = 1;
        int left = 0, right = 1, firstPair = -1;
        char prev = s.charAt(0);
        for (; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (cur == prev) {
                if (firstPair > left) {
                    left = firstPair;
                }
                firstPair = right;
            }
            prev = cur;
            res = Math.max(res, right - left + 1);
        }
        res = Math.max(res, right - left);
        return res;
    }
}
