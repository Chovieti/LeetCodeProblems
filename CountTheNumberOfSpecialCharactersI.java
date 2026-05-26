import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfSpecialCharactersI {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) set.add(word.charAt(i));
        return (int) set.stream()
                .filter(k -> Character.isUpperCase(k) && set.contains(Character.toLowerCase(k)))
                .count();
    }
}
