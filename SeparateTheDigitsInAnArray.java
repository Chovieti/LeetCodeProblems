import java.util.ArrayList;
import java.util.List;

public class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            separateDigit(result, nums[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void separateDigit(List<Integer> result, int number) {
        int div = 100_000;
        while (div > number) div /= 10;
        while (div > 0) {
            result.add((number / div) % 10);
            div /= 10;
        }
    }
}
