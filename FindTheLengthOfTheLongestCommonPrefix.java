import java.util.HashSet;
import java.util.Set;

public class FindTheLengthOfTheLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) fillSet(arr1[i], set);
        int max = 0;
        for (int i = 0; i < arr2.length; i++) max = Math.max(max, checkPrefix(arr2[i], set));
        return max;
    }

    private void fillSet(int number, Set<Integer> set) {
        int div = 100_000_000;
        while (div > number) div /= 10;
        while (div > 0) {
            set.add(number / div);
            div /= 10;
        }
    }

    private int checkPrefix(int number, Set<Integer> set) {
        int div = 1;
        while (div <= number) {
            if (set.contains(number/ div)) return calcLength(number / div);
            div *= 10;
        }
        return 0;
    }

    private int calcLength(int number) {
        int length = 0;
        while (number > 0) {
            number /= 10;
            length++;
        }
        return length;
    }
}
