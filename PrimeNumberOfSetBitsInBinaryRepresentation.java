public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (itsSimple(countBits(i))) count++;
        }
        return count;
    }

    private int countBits(int number) {
        int count = 0;
        // 20 от ограничения вводимых чисел в 10^6
        for (int i = 0; i < 20; i++) {
            if (((number >> i) & 1) == 1) count++;
        }
        return count;
    }

    private boolean itsSimple(int number) {
        switch (number) {
            case 2, 3, 5, 7, 11, 13, 17, 19 -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }
}
