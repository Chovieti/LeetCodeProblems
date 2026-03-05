public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int countO = 0, countI = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countO += (i % 2 == 0 && c == '0') || (i % 2 == 1 && c == '1') ? 0 : 1;
            countI += (i % 2 == 0 && c == '1') || (i % 2 == 1 && c == '0') ? 0 : 1;
        }
        return Math.min(countO, countI);
    }
}
