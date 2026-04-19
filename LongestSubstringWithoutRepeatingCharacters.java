import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int result = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (hash.containsKey(c)) {
                int newLeft = hash.get(c) + 1;
                for (; left < newLeft; left++) {
                    hash.remove(s.charAt(left));
                }
            }
            hash.put(c, right);
            result = Math.max(result, hash.size());
        }
        return result;
    }
}
