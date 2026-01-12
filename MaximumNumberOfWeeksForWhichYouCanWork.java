public class MaximumNumberOfWeeksForWhichYouCanWork {
    public long numberOfWeeks(int[] milestones) {
        long count = 0L;
        int max = 0;
        for (int i = 0; i < milestones.length; i++) {
            if (milestones[i] > max) {
                count += max;
                max = milestones[i];
            } else {
                count += milestones[i];
            }
        }
        if (max - 1 > count) {
            return ((count * 2L) + 1);
        } else {
            return (count + max);
        }
    }
}
