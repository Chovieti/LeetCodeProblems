public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == goal.charAt(i) && check(s, goal, i)) return true;
        }
        return false;
    }

    private boolean check(String s, String goal, int start) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt((i + start) % goal.length())) return false;
        }
        return true;
    }
}
