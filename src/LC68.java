import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LC68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
//        dfs(res, 0, words, maxWidth);
        int curr = 0;
        while (curr < words.length) {
            StringJoiner sj = new StringJoiner(" ");
            while (curr < words.length && (sj.length()==0?words[curr].length()<=maxWidth:sj.length() + words[curr].length() < maxWidth)) {
                sj.add(words[curr]);
                curr++;
            }

            if (curr == words.length) {
                String str = sj.toString();
                for (int i = 0; i < maxWidth - sj.length(); i++) {
                    str = str + " ";
                }
                res.add(str);
                break;
            }
            if (sj.length() == maxWidth) {
                res.add(sj.toString());
            } else {
                String[] split = sj.toString().split(" ");
                if (split.length == 1) {
                    String str = split[0];
                    for (int i = 0; i < maxWidth - split[0].length(); i++) {
                        str = str + " ";
                    }
                    res.add(str);
                } else {
                    int l = 0;
                    for (int i = 0; i < split.length; i++) {
                        l = l + split[i].length();
                    }
                    int mod = (maxWidth - l) % (split.length - 1);
                    if (mod == 0) {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < (maxWidth - l) / (split.length - 1); i++) {
                            sb.append(" ");
                        }
                        StringJoiner stringJoiner = new StringJoiner(new String(sb));
                        for (int i = 0; i < split.length; i++) {
                            stringJoiner.add(split[i]);
                        }
                        res.add(stringJoiner.toString());
                    } else {
                        int rest = mod;
                        int spacelen = (maxWidth - l) / (split.length - 1);
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < split.length; i++) {
                            sb.append(split[i]);
                            if (i != split.length - 1) {
                                int limit = spacelen;
                                if (rest != 0) {
                                    limit = limit + 1;
                                    rest = rest - 1;
                                }
                                for (int j = 0; j < limit; j++) {
                                    sb.append(" ");
                                }
                            }
                        }
                        res.add(new String(sb));
                    }
                }
            }
        }
        return res;
    }

    void dfs(List<String> res, int curr, String[] words, int maxWidth) {
        StringJoiner sj = new StringJoiner(" ");
        while (true) {
            if (curr >= words.length) {
                break;
            }
            if (sj.length() + words[curr].length() < maxWidth) {
                sj.add(words[curr]);
                curr++;
            } else {
                break;
            }
        }
        if (curr == words.length) {
            String str = sj.toString();
            for (int i = 0; i < maxWidth - sj.length(); i++) {
                str = str + " ";
            }
            res.add(str);
            return;
        }
        if (sj.length() == maxWidth) {
            res.add(sj.toString());
        } else {
            String[] split = sj.toString().split(" ");
            if (split.length == 1) {
                String str = split[0];
                for (int i = 0; i < maxWidth - split[0].length(); i++) {
                    str = str + " ";
                }
                res.add(str);
            } else {
                int l = 0;
                for (int i = 0; i < split.length; i++) {
                    l = l + split[i].length();
                }
                int mod = (maxWidth - l) % (split.length - 1);
                if (mod == 0) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < (maxWidth - l) / (split.length - 1); i++) {
                        sb.append(" ");
                    }
                    StringJoiner stringJoiner = new StringJoiner(new String(sb));
                    for (int i = 0; i < split.length; i++) {
                        stringJoiner.add(split[i]);
                    }
                    res.add(stringJoiner.toString());
                } else {
                    int rest = mod;
                    int spacelen = (maxWidth - l) / (split.length - 1);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < split.length; i++) {
                        sb.append(split[i]);
                        if (i != split.length - 1) {
                            int limit = spacelen;
                            if (rest != 0) {
                                limit = limit + 1;
                                rest = rest - 1;
                            }
                            for (int j = 0; j < limit; j++) {
                                sb.append(" ");
                            }
                        }
                    }
                    res.add(new String(sb));
                }
            }
        }
        dfs(res, curr, words, maxWidth);
    }

    @Test
    public void test() {
        fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6);
    }
}
