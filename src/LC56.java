import java.util.*;

public class LC56 {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Integer tar = map.floorKey(intervals[i][1]);
            int lcurr = intervals[i][0], rcurr = intervals[i][1];
            while (tar != null && map.get(tar) >= lcurr) {
                lcurr = Math.min(lcurr, tar);
                rcurr = Math.max(rcurr, map.get(tar));
                map.remove(tar);
                tar = map.floorKey(rcurr);
            }
            map.put(lcurr, rcurr);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = list.get(i).getValue();
        }
        return res;
    }
}
