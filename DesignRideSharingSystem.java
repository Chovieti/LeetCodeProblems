import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignRideSharingSystem {
class RideSharingSystem {
    Queue<Integer> driver;
    Map<Integer, Integer> rider;
    public RideSharingSystem() {
        driver = new LinkedList<>();
        rider = new LinkedHashMap<>();
    }

    public void addRider(int riderId) {
        rider.put(riderId, riderId);
    }

    public void addDriver(int driverId) {
        driver.add(driverId);
    }

    public int[] matchDriverWithRider() {
        if (driver.isEmpty() || rider.isEmpty()) return new int[]{-1, -1};
        int riderId = rider.keySet().iterator().next();
        return new int[]{driver.poll(), rider.remove(riderId)};
    }

    public void cancelRider(int riderId) {
        rider.remove(riderId);
    }
}
}
