public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1; j >= 0;) {
            if (i < 0) {
                nums1[j] = nums2[j];
                j--;
            } else if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else if (nums1[i] < nums2[j]) {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
    }
}
