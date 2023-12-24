import java.util.Arrays;

public class LC72 {
    public int minDistance(String word1, String word2) {
        Integer[][] matrix = new Integer[word1.length()][word2.length()];
        return dfs(matrix, word1, word2, 0, 0);
    }

    int dfs(Integer[][] matrix, String word1, String word2, int w1curr, int w2curr) {
        if (w1curr == word1.length()) {
            return word2.length() - w2curr;
        }
        if (w2curr == word2.length()) {
            return word1.length() - w1curr;
        }
        if (matrix[w1curr][w2curr] != null) {
            return matrix[w1curr][w2curr];
        }
        if (word1.charAt(w1curr) == word2.charAt(w2curr)) {
            int dfs = dfs(matrix, word1, word2, w1curr + 1, w2curr + 1);
            matrix[w1curr][w2curr] = dfs;
        } else {
            int insert = 1 + dfs(matrix, word1, word2, w1curr, w2curr + 1);
            int del = 1 + dfs(matrix, word1, word2, w1curr + 1, w2curr);
            int replace = 1 + dfs(matrix, word1, word2, w1curr + 1, w2curr + 1);
            matrix[w1curr][w2curr] = Math.min(Math.min(insert, del), replace);
        }
        return matrix[w1curr][w2curr];
    }
}
