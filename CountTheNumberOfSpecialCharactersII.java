public class CountTheNumberOfSpecialCharactersII {
    public int numberOfSpecialChars(String word) {
        int lower = 0, doub = 0, fin = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'a') {
                lower |= 1 << (c - 'a');
                if (((fin >> (c - 'a')) & 1) == 1) doub |= 1 << (c - 'a');
            } else if (((lower >> (c - 'A')) & 1) == 1) {
                fin |= 1 << (c - 'A');
            } else {
                doub |= 1 << (c - 'A');
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if ((fin >> i & 1) == 1 && (doub >> i & 1) != 1) count++;
        }
        return count;
    }
}
