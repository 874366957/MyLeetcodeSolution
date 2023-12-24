import java.util.*;

public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], intervals[i][1]);
        }
        Integer tar = map.floorKey(newInterval[1]);
        int lcurr = newInterval[0], rcurr = newInterval[1];
        while (tar != null && map.get(tar) >= lcurr) {
            lcurr = Math.min(lcurr, tar);
            rcurr = Math.max(rcurr, map.get(tar));
            map.remove(tar);
            tar = map.floorKey(rcurr);
        }
        map.put(lcurr, rcurr);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = list.get(i).getValue();
        }
        return res;
    }
}
