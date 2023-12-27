import java.util.*;

public class LC1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(rounds[0], 1);
        for (int i = 0; i < rounds.length - 1; i++) {
            if (rounds[i + 1] > rounds[i]) {
                for (int j = rounds[i] + 1; j <= rounds[i + 1]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            } else {
                for (int j = rounds[i] + 1; j <= n; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
                for (int j = 1; j <= rounds[i + 1]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> res = new ArrayList<>();
        int maxValue = entryList.get(0).getValue();
        for (int i = 0; i < entryList.size(); i++) {
            if (entryList.get(i).getValue() < maxValue) {
                break;
            }
            res.add(entryList.get(i).getKey());
        }
        res.sort((a, b) -> a - b);
        return res;
    }
}
