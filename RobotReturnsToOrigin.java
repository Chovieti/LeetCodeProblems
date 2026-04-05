public class RobotReturnsToOrigin {
    public boolean judgeCircle(String moves) {
        int hor = 0, ver = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U' -> ver++;
                case 'D' -> ver--;
                case 'R' -> hor++;
                case 'L' -> hor--;
            }
        }
        return (hor == 0 && ver == 0);
    }
}
