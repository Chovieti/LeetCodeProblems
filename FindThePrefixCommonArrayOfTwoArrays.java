import java.util.HashMap;
import java.util.Map;

public class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        int count = 0;
        int[] C = new int[n];
        for (int i = 0; i < n; i++) {
            if (map.merge(A[i], 1, Integer::sum) >= 2) count++;
            if (map.merge(B[i], 1, Integer::sum) >= 2) count++;
            C[i] = count;
        }
        return C;
    }
}
