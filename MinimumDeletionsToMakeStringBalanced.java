public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int l = s.length(), aCount = 0, bCount = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') aCount++;
        }
        int result = aCount;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != 'a') {
                bCount++;
            } else {
                aCount--;
            }
            result = Math.min(result, aCount + bCount);
        }

        return result;
    }
}
