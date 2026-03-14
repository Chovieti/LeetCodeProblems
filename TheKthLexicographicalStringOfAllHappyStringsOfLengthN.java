public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    public String getHappyString(int n, int k) {
        int partSize = (int) (3 * Math.pow(2.0, (n - 1)));
        if (k > partSize) return "";

        StringBuilder builder = new StringBuilder();
        k--;

        char prev = 0;

        while (builder.length() < n) {
            char[] vars = switch (prev) {
                case 'a' -> new char[]{'b', 'c'};
                case 'b' -> new char[]{'a', 'c'};
                case 'c' -> new char[]{'a', 'b'};
                default -> new char[]{'a', 'b', 'c'};
            };
            partSize /= vars.length;
            prev = vars[k / partSize];
            builder.append(prev);
            k -= ((k / partSize) * partSize);
        }

        return builder.toString();
    }
}
