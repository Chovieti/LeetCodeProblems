public class ComplementOfBaseTenInteger {
    public int bitwiseComplement(int n) {
        return (n == 0) ? 1 : reverseBits(n);
    }

    private int reverseBits(int n) {
        boolean first = false;
        for (int i = 30; i >= 0; i--) {
            int bit = (n >>> i) & 1;
            if (!first && bit == 0) {
                continue;
            }
            first = true;
            switch (bit) {
                case 1 -> n &= (~(1 << i));
                case 0 -> n |= (1 << i);
            }
        }
        return n;
    }
}
