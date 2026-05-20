public class FindThePrefixCommonArrayOfTwoArrays {
    // Битовая маска для просмотра частоты, работает за счет ограничений в n <= 50
//    public int[] findThePrefixCommonArray(int[] A, int[] B) {
//        int n = A.length, count = 0;
//        long freq = 0L;
//        int[] C = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (((freq >> A[i]) & 1) == 1) count++;
//            freq |= 1L << A[i];
//            if (((freq >> B[i]) & 1) == 1) count++;
//            freq |= 1L << B[i];
//            C[i] = count;
//        }
//        return C;
//    }

    // Более скупой по памяти вариант, где я даже не создаю новый массив, а переписываю старый
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, count = 0;
        long freq = 0L;
        for (int i = 0; i < n; i++) {
            if (((freq >> A[i]) & 1) == 1) count++;
            freq |= 1L << A[i];
            if (((freq >> B[i]) & 1) == 1) count++;
            freq |= 1L << B[i];
            A[i] = count;
        }
        return A;
    }
}
