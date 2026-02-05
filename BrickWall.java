import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int result = Integer.MIN_VALUE;
        int width = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            width += wall.get(0).get(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int tmpWidth = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                tmpWidth += wall.get(i).get(j);
                map.merge(tmpWidth, 1, Integer::sum);
            }
        }
        for (Integer value : map.values()) {
            result = Math.max(result, value);
        }
        return result == Integer.MIN_VALUE ? wall.size() : wall.size() - result;
    }
}
