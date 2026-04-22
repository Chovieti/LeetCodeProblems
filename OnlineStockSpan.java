import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class OnlineStockSpan {
class StockSpanner {
    private Deque<Integer> array;
    private Iterator<Integer> iter;
    int res;
    public StockSpanner() {
        array = new ArrayDeque<>();
        res = 0;
    }

    public int next(int price) {
        array.add(price);
        if (price >= array.peekLast()) {
            iter = array.descendingIterator();
            res = 0;
            while (iter.hasNext()) {
                int tmp = iter.next();
                if (tmp <= price) {
                    res++;
                } else {
                    break;
                }
            }
        } else {
            res = 1;
        }
        return res;
    }
}
}
