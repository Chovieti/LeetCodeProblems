import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int L = s.length();
        boolean[] dp = new boolean[L + 1];
        dp[0] = true;
        for (int i = 0; i <= L; i++) {
            if (dp[i]) {
                for (int j = 0; j < wordDict.size(); j++) {
                    int len = wordDict.get(j).length();
                    if ((i + len) <= L && s.substring(i, i + len).equals(wordDict.get(j))) {
                        dp[i + len] = true;
                    }
                }
            }
        }
        return dp[L];
    }
}
