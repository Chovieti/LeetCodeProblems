public class BinaryGap {
    public int binaryGap(int n) {
        boolean start = false;
        int result = 0;
        for (int i = 0, tmp = 0; i < 32; i++) {
            boolean bit = ((n >>> i) & 1) == 1;
            if (!start) {
                if (bit) start = true;
                continue;
            }
            tmp++;
            if (bit) {
                result = Math.max(result, tmp);
                tmp = 0;
            }
        }
        return result;
    }
}
