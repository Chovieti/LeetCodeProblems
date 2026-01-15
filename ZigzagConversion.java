import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> tmpString = new ArrayList<>(numRows);
        int length = s.length();
        for (int i = 0; i < numRows; i++) {
            tmpString.add(new StringBuilder(length));
        }
        boolean vertical = true;
        int numberVertical = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            tmpString.get(numberVertical).append(c);
            if (vertical) {
                if (numberVertical + 1 != numRows) numberVertical++;
                if (numberVertical + 1 == numRows) {
                    vertical = false;
                }
            } else {
                if (numberVertical > 0) numberVertical--;
                if (numberVertical == 0) vertical = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(tmpString.get(i));
        }
        return result.toString();
    }
}
