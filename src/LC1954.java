import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC1954 {
    public long minimumPerimeter(long neededApples) {
        ArrayList<Long> cache = new ArrayList<>();
        cache.add(12l);
        while (cache.get(cache.size() - 1) < neededApples) {
            int len = cache.size() + 1;
            int add = 0;
            for (int i = len; i <= 2 * len; i++) {
                add += i;
            }
            int part = 2 * add - len - 2 * len;
            long l = cache.get(cache.size() - 1) + 4 * part;
            cache.add(l);
        }
        return 8 * cache.size();
    }
}
