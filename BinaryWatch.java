import java.util.*;

public class BinaryWatch {

    private final static Map<Integer, List<Integer>> bits = new HashMap(6);

    public List<String> readBinaryWatch(int turnedOn) {
        calculateAllBits(turnedOn);
        return createAllTimes(turnedOn);
    }

    private void calculateAllBits(int turnedOn) {
        for (int i = 0, bit = 1; i <= turnedOn; i++, bit = 1) {
            List<Integer> listBits = new ArrayList<>();
            if (i == 0) {
                listBits.add(0);
            } else if (i == 1) {
                while (bit < 60) {
                    listBits.add(bit);
                    bit *= 2;
                }
            } else {
                for (int j = 1; j < i; j++) bit *= 2;
                List<Integer> prevBits = bits.get(i - 1);
                while (bit < 60) {
                    for (int j = 0; j < prevBits.size(); j++) {
                        if (prevBits.get(j) >= bit) break;
                        int tmp = bit + prevBits.get(j);
                        listBits.add(tmp);
                    }
                    bit *= 2;
                }
            }
            bits.put(i, listBits);
        }
    }

    private List<String> createAllTimes(int turnedOn) {
        List<String> result = new ArrayList<>();
        int bitsMinute = turnedOn, bitsHours = 0;
        while (bitsMinute > 5) {
            bitsMinute--;
            bitsHours++;
        }
        while (bitsHours <= 3 && bitsMinute >= 0) {
            List<Integer> hours = bits.get(bitsHours);
            List<Integer> minutes = bits.get(bitsMinute);

            for (int i = 0, hour; i < hours.size(); i++) {
                hour = hours.get(i);
                if (hour > 11) continue;
                for (int j = 0, minute; j < minutes.size(); j++) {
                    minute = minutes.get(j);
                    if (minute > 59) break;
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }

            bitsMinute--; bitsHours++;
        }
        return result;
    }
}
