import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        this.dfs(matrix, visited, 1, 0, 0, res);
        return res;
    }

    void dfs(int[][] matrix, boolean[][] visited, int direction, int x, int y, List<Integer> res) {
        if (checkAllVisited(visited)) {
            return;
        }
        res.add(matrix[x][y]);
        visited[x][y] = true;

        int[] dir = direction(x, y, direction, visited);
        dfs(matrix, visited, dir[2], dir[0], dir[1], res);
    }

    int[] direction(int x, int y, int direction, boolean[][] visited) {
        int h = visited.length, w = visited[0].length;
        int nextx = x, nexty = y;
        if (direction == 1) {
            if (nexty + 1 >= w || visited[nextx][nexty + 1]) {
                return new int[]{nextx + 1, nexty, changeDirection(1)};
            }
            return new int[]{nextx, nexty + 1, 1};
        }
        if (direction == 2) {
            if (nextx + 1 >= h || visited[nextx + 1][nexty]) {
                return new int[]{nextx, nexty - 1, changeDirection(2)};
            }
            return new int[]{nextx + 1, nexty, 2};
        }
        if (direction == 3) {
            if (nexty - 1 < 0 || visited[nextx][nexty - 1]) {
                return new int[]{nextx - 1, nexty, changeDirection(3)};
            }
            return new int[]{nextx, nexty - 1, 3};
        } else {
            if (nextx - 1 < 0 || visited[nextx - 1][nexty]) {
                return new int[]{nextx, nexty + 1, changeDirection(0)};
            }
            return new int[]{nextx - 1, nexty, 0};
        }
    }

    int changeDirection(int x) {
        return x == 3 ? 0 : x + 1;
    }

    boolean checkAllVisited(boolean[][] visited) {

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
