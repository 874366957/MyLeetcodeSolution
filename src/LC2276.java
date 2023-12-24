import java.util.TreeMap;

public class LC2276 {
    class CountIntervals {

        // 统计区间里面元素个数
        int sum = 0;
        // 存储所有的不重叠区间左右端点
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public CountIntervals() {

        }

        public void add(int left, int right) {
            Integer tar = map.floorKey(right);
            int lcurr = left, rcurr = right;
            while (tar != null && map.get(tar) >= lcurr) {
                lcurr = Math.min(lcurr, tar);
                rcurr = Math.max(rcurr, map.get(tar));
                map.remove(tar);
                sum = sum - map.get(tar) + tar - 1;
                tar = map.floorKey(rcurr);
            }
            map.put(lcurr, rcurr);
            sum = sum + rcurr - lcurr + 1;
        }

        public int count() {
            return sum;
        }
    }
}
