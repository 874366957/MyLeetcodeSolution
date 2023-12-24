public class LC44 {
    public boolean isMatch(String s, String p) {
        Boolean[][] matrix = new Boolean[s.length()][p.length()];
        return dfs(s, p, matrix, s.length(), p.length());
    }

    boolean dfs(String source, String target, Boolean[][] matrix, int sourcelen, int targetlen) {
        if (source.isEmpty() || target.isEmpty()) {
            if (target.isEmpty()) {
                return source.isEmpty();
            }
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        int x = sourcelen - source.length();
        int y = targetlen - target.length();
        if (matrix[x][y] != null) {
            return matrix[x][y];
        }
        if (source.equals(target)) {
            matrix[x][y] = true;
            return true;
        }
        char sourcech = source.charAt(0);
        char targetch = target.charAt(0);
        if (sourcech == targetch || targetch == '?') {
            boolean dfs = dfs(source.substring(1), target.substring(1), matrix, sourcelen, targetlen);
            matrix[x][y] = dfs;
            return dfs;
        } else if (targetch == '*') {
            boolean b = dfs(source.substring(1), target, matrix, sourcelen, targetlen) ||
                    dfs(source, target.substring(1), matrix, sourcelen, targetlen);
            matrix[x][y] = b;
            return b;
        } else {
            matrix[x][y] = false;
            return false;
        }
    }
}
