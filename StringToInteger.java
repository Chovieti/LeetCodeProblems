public class StringToInteger {
    public int myAtoi(String s) {
        boolean start = true, hasSign = false, hasValue = false;
        boolean signValue = true;
        long tmpNumber = 0L;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Пропуск начальных пробелов
            while (c == ' ' && start) {
                if (i + 1 < s.length()) {
                    c = s.charAt(++i);
                } else {
                    return 0;
                }
            }
            start = false;
            // Определить знак
            if (!hasSign && (c == '-' || c == '+')) {
                if (c == '-') {
                    signValue = false;
                }
                hasSign = true;
                if (i + 1 < s.length()) c = s.charAt(++i);
            }
            // Считать число
            if (c >= '0' && c <= '9') {
                if (!hasSign) hasSign = true;
                tmpNumber *= 10;
                tmpNumber += c - 48;
                hasValue = true;
                if (tmpNumber > Integer.MAX_VALUE) break;
            }
            if (!(c >= '0' && c <= '9') && (hasValue || hasSign)) break;
            if (((c >= 'A' && c <= 'z') || c == '.')) break;
        }
        if (tmpNumber > Integer.MAX_VALUE) {
            return signValue ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (!signValue) tmpNumber = -tmpNumber;
        return (int) tmpNumber;
    }
}
