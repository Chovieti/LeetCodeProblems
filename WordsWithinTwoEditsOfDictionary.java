import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String cur = queries[i];
            for (int j = 0; j < dictionary.length; j++) {
                if (checkWords(cur, dictionary[j])) {
                    result.add(cur);
                    break;
                }
            }
        }
        return result;
    }

    private boolean checkWords(String querie, String dict) {
        for (int i = 0, count = 0; i < querie.length(); i++) {
            if (querie.charAt(i) != dict.charAt(i)) count++;
            if (count > 2) return false;
        }
        return true;
    }
}
