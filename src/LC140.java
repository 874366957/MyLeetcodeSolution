import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //新建Set用于存放不同的句子
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            String str = wordDict.get(i);
            //若相等则直接添加进结果
            if (str.equals(s)) {
                res.add(str);
                continue;
            }
            //若s以str开头则进行dfs
            if (s.startsWith(str)) {
                dfs(res, wordDict, s.substring(str.length()), new StringBuffer(str));
            }
        }
        return new ArrayList<>(res);
    }

    void dfs(HashSet<String> res, List<String> dicts, String source, StringBuffer str) {
        if (source.isEmpty()) {
            if (str.length() > 0) {
                res.add(new String(str));
            }
            return;
        }
        for (String dictword : dicts) {
            StringBuffer next = new StringBuffer(str);
            if (dictword.equals(source)) {
                next.append(" ").append(dictword);
                res.add(new String(next));
                continue;
            }
            if (source.startsWith(dictword)) {
                next.append(" ").append(dictword);
                dfs(res, dicts, source.substring(dictword.length()), next);
            }
        }
    }
}
