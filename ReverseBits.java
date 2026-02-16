public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            if ((n >> (31 - i) & 1) == 1) result |= (1 << i);
        }
        return result;
    }
}
