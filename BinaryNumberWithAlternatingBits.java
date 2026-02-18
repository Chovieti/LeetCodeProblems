public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        boolean first = true;
        int prev = -1;
        for (int i = 30; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (first && bit == 0) {
                continue;
            } else {
                first = false;
            }
            if (bit == prev) return false;
            prev = bit;
        }
        return true;
    }
}
