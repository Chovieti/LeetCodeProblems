import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        boolean first = true;
        int start = 0, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (first) {
                first = false;
                start = cur;
                prev = cur;
                continue;
            }
            if (prev + 1 < cur) {
                result.add(createString(start, prev));
                start = cur;
            }
            prev = cur;
        }
        if (!first) result.add(createString(start, prev));
        return result;
    }

    private String createString(int start, int last) {
        StringBuilder builder = new StringBuilder();
        builder.append(start);
        if (start != last) {
            builder.append("->");
            builder.append(last);
        }
        return builder.toString();
    }
}
