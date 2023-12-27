import java.util.ArrayList;
import java.util.List;

public class LC1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 != 0) {
            return res;
        }
        if (tomatoSlices > 4 * cheeseSlices) {
            return res;
        }
        if (tomatoSlices < 2 * cheeseSlices) {
            return res;
        }
        int maxCount = (tomatoSlices - 2 * cheeseSlices) / 2;
        res.add(maxCount);
        res.add(cheeseSlices - maxCount);
        return res;
    }
}
