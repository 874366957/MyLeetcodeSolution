import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC386 {
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(n, String.valueOf(i));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(Integer.parseInt(list.get(0)));
        }
        return res;
    }
}
