import org.junit.Test;

public class LC48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        for (int i = 0; i <= len / 2; i++) {
            for (int j = i; j <= len - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[j][i] = matrix[len - i][j];
                matrix[len - i][j] = matrix[len - j][len - i];
                matrix[j][len - i] = temp;
            }
        }
    }
    @Test
    public void test(){
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
