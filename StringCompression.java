public class StringCompression {
    public int compress(char[] chars) {
        char prev = 0;
        int d = 0;
        for (int i = 0, count = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == prev) {
                count++;
                if (i + 1 >= chars.length || chars[i + 1] != prev) {
                    d = addNumber(chars, count, d);
                }
            } else {
                prev = cur;
                chars[d] = prev;
                d++;
                count = 1;
            }
        }
        System.arraycopy(chars, 0, chars, 0, d);
        return d;
    }

    private int addNumber(char[] chars, int count, int i) {
        int div = 1000;
        while (div > count) div /= 10;
        while (div > 0) {
            chars[i] = (char) (((count / div) % 10) + '0');
            div /= 10;
            i++;
        }
        return i;
    }
}
