public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                if (needle.length() == 1) return index;
                for (int j = 1; j < needle.length() && (i + j) < haystack.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    if (j + 1 >= needle.length()) return index;
                }
                index = -1;
            }
        }
        return index;
    }
}
