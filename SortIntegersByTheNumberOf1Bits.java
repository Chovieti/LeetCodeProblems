import java.util.*;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[arr.length];
        int maxKey = 0;
        for (int i = 0; i < arr.length; i++) {
            int key = countBits(arr[i]);
            if (map.containsKey(key)) {
                map.get(key).add(arr[i]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(key, list);
            }
            maxKey = Math.max(maxKey, key);
        }
        for (int i = 0, index = 0; i <= maxKey; i++) {
            List<Integer> list = map.get(i);
            if (list == null) continue;
            Collections.sort(list);
            for (int j = 0; j < list.size(); j++) {
                result[index] = list.get(j);
                index++;
            }
        }
        return result;
    }

    private int countBits(int number) {
        int count = 0;
        for (int i = 0; i < 32; i++) if (((number >>> i) & 1) == 1) count++;
        return count;
    }
}
