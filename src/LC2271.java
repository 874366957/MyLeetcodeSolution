import org.junit.Test;

import java.util.Arrays;

public class LC2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = 0;
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int start = tiles[0][0], end = tiles[tiles.length - 1][1];
        int len = end - start + 1;
        if (carpetLen >= len) {
            int cnt = 0;
            for (int i = 0; i < tiles.length; i++) {
                cnt = cnt + tiles[i][1] - tiles[i][0] + 1;
            }
            return cnt;
        }
        int[] matrix = new int[len];
        for (int j = 0; j < tiles.length; j++) {
            for (int i = tiles[j][0] - start; i <= tiles[j][1] - start; i++) {
                matrix[i] = 1;
            }
        }
        for (int i = 0; i <= len - carpetLen; i++) {
            int cnt = 0;
            for (int j = i; j < i + carpetLen; j++) {
                if (matrix[j] == 1) {
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
        }

        return max;
    }

    @Test
    public void test() {
        int i = maximumWhiteTiles(new int[][]{{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}}, 10);
        System.out.println(i);
    }
}
