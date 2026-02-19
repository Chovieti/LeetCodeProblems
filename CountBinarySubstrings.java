public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 1, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
                for (int tmpI = i + 1, tmpJ = j - 1; tmpI < s.length() && tmpJ >= 0; tmpI++, tmpJ--) {
                    if (s.charAt(tmpI) == s.charAt(i) && s.charAt(tmpJ) == s.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
