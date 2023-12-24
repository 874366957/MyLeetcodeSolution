import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        for (int l = 0; l < n; l++) {
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = '.';
                }
            }
            matrix[0][l] = 'Q';
            dfs(matrix, 1);
        }
        return res;
    }

    void dfs(char[][] matrix, int floor) {
        if (floor == matrix.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < matrix.length; j++) {
                    stringBuffer.append(matrix[i][j]);
                }
                list.add(new String(stringBuffer));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < matrix.length; col++) {
            boolean flag = checkIllegal(matrix, floor, col);
            if (!flag) {
                continue;
            }
            matrix[floor][col] = 'Q';
            dfs(matrix, floor + 1);
            matrix[floor][col] = '.';
        }
    }

    private boolean checkIllegal(char[][] matrix, int floor, int col) {
        int length = matrix.length;
        //检查行有无Q
        for (int i = 0; i < length; i++) {
            if (matrix[floor][i] == 'Q') {
                return false;
            }
        }
        //检查列有无Q；
        for (int i = 0; i < length; i++) {
            if (matrix[i][col] == 'Q') {
                return false;
            }
        }
        //检查左上对角线
        int x1 = floor, y1 = col;
        while (x1 >= 0 && y1 >= 0) {
            if (matrix[x1][y1] == 'Q') {
                return false;
            }
            x1--;
            y1--;
        }
        //检查右上对角线
        int x2 = floor, y2 = col;
        while (x2 >= 0 && y2 < length) {
            if (matrix[x2][y2] == 'Q') {
                return false;
            }
            x2--;
            y2++;
        }
        return true;
    }
}
