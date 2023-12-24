public class LC28 {
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }
        String[] split = haystack.split(needle);
        if (split.length == 0) {
            return 0;
        }
        return split[0].length();
    }
}
