import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<Set<Character>> keyboard = new ArrayList<>(3);
        keyboard.add(Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        keyboard.add(Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        keyboard.add(Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<String> result = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            int rowNumber = -1;
            for (int j = 0; j < 3; j++) if (keyboard.get(j).contains(word.charAt(0))) rowNumber = j;
            Set<Character> row = keyboard.get(rowNumber);
            for (int j = 1; j < word.length(); j++) {
                if (!row.contains(word.charAt(j))) {
                    rowNumber = -1;
                    break;
                }
            }
            if (rowNumber != -1) result.add(words[i]);
        }
        return result.toArray(new String[0]);
    }
}
