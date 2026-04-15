public class ShortestDistanceToTargetStringInACircularArray {
    public int closestTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) return 0;
        int n = words.length;
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (words[(startIndex + i + n) % n].equals(target)) result = Math.min(result, i);
            if (words[(startIndex - i + n) % n].equals(target)) result = Math.min(result, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
