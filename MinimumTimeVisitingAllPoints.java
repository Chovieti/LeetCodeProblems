public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int[] last = points[0];
        int[] current = points[0];
        int dx = 0, dy = 0;
        for (int i = 1; i < points.length; i++) {
            current = points[i];
            dx = current[0] - last[0];
            dy = current[1] - last[1];
            if (Math.abs(dx) > 0 && Math.abs(dy) > 0) {
                int distance = Math.min(Math.abs(dx), Math.abs(dy));
                time += distance;
                dx = dx - ((dx > 0) ? distance : -distance);
                dy = dy - ((dy > 0) ? distance : -distance);
            }
            time += (Math.abs(dx) + Math.abs(dy));
            last = current;
        }
        return time;
    }
}
