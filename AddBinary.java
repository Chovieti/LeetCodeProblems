public class AddBinary {
    public String addBinary(String a, String b) {
        int length = (Math.max(a.length(), b.length())) * 2;
        StringBuilder builder = new StringBuilder(length);
        int A = 0, B = 0, bonus = 0;
        for (int i = 1; i <= length; i++) {
            if (i > a.length() && i > b.length() && bonus == 0) break;
            A = (i <= a.length() ? a.charAt(a.length() - i) : '0') == '0' ? 0 : 1;
            B = (i <= b.length() ? b.charAt(b.length() - i) : '0') == '0' ? 0 : 1;
            bonus += A + B;
            builder.append(bonus % 2 == 0 ? '0' : '1');
            bonus = bonus / 2;
        }
        return builder.reverse().toString();
    }
}
