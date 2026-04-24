public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int count = 0, empty = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R' -> count++;
                case 'L' -> count--;
                default -> empty++;
            }
        }
        return Math.abs(count) + empty;
    }
}
