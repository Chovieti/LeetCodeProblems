import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfSpecialCharactersI {
    // Битовые флаги(вместо них вполне можно использовать и массив boolean)
    public int numberOfSpecialChars(String word) {
        int lower = 0, upper = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'a') {
                lower |= 1 << (c - 'a');
            } else {
                upper |= 1 << (c - 'A');
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if ((lower >> i & 1) == 1 && (upper >> i & 1) == 1) count++;
        }
        return count;
    }
    // StreamApi
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) set.add(word.charAt(i));
        return (int) set.stream()
                .filter(k -> Character.isUpperCase(k) && set.contains(Character.toLowerCase(k)))
                .count();
    }
}
