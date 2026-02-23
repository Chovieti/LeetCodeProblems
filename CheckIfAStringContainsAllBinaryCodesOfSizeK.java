import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int needFind = (int) Math.pow(2.0, k);
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (!set.contains(sub)) {
                set.add(sub);
                needFind--;
                if (needFind == 0) break;
            }
        }
        return needFind == 0;
    }
}
