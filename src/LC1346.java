import java.util.Arrays;

public class LC1346 {
    private int M;//座位行数
    private int N;//每行座位数
    private int[] initStatusOfRows;//初始时，各行座位的状态

    public int maxStudents(char[][] seats) {
        M = seats.length;
        N = seats[0].length;//每行座位数
        initStatusOfRows = compress(seats);//初始时，各行座位的状态
        int[][] cache = new int[M][(1 << N)];
        for (int[] row : cache) Arrays.fill(row, -1);
        return dfsProcess(0, initStatusOfRows[0], cache);//第0行座位状态总是等于初始状态
    }

    /**
     * 按行尝试在座位上填充学生，求当前行座位状态为statusOfCurRow的情况下，在第rowNum~M-1行上最多安排多少学生
     *
     * @param rowNum         当前考察到的座位行号
     * @param statusOfCurRow 当前行的座位状态，第0~N-1 bit位上如果是1，表示该位置可以坐人；当前行状态是由该行初始状态和上一行学生分布状态决定的
     * @param cache          记忆化搜索的缓存数组 rowNum:0~M-1  statusOfCurRow:0~((1<<N)-1)
     * @return
     */
    private int dfsProcess(int rowNum, int statusOfCurRow, int[][] cache) {
        if (cache[rowNum][statusOfCurRow] != -1) {
            return cache[rowNum][statusOfCurRow];
        }
        int res = 0;//返回值
        //穷举当前行学生所有可能的分布状态
        int limit = (1 << N);
        for (int studentOfCurRow = 0; studentOfCurRow < limit; ++studentOfCurRow) {//StudentOfCurRow表示当前行学生分布状态，某个bit为1表示该位置有学生坐
            //当前行学生分布首先不能与当前行座位分布冲突（不能坐到不可以坐的位置），
            //这意味着在0~N-1 bit范围上，如果statusOfCurRow在该bit为0，StudentOfCurRow在该bit只能为0
            if (((~statusOfCurRow) & studentOfCurRow) != 0) {
                continue;
            }
            //当前行学生分布，任意两学生之间不能相邻
            if ((studentOfCurRow & (studentOfCurRow >> 1)) != 0) {
                continue;
            }
            int count = 0;//统计人数
            for (int i = 0; i < N; i++) {
                count += (studentOfCurRow >> i) & 1;
            }
            if (rowNum < M - 1) {//如果当前行不是最后一行(这个代码块也是隐含的递归出口)
                //求下一行座位状态
                int statusOfNextRow = initStatusOfRows[rowNum + 1];
                //由于本行的学生分布studentOfCurRow会影响下一行，具体来说：(studentOfCurRow>>1)或者(studentOfCurRow<<1)哪个bit位为1，
                //那么statusOfNextRow的该bit位必须为0
                statusOfNextRow &= (~(studentOfCurRow >> 1));
                statusOfNextRow &= (~(studentOfCurRow << 1));
                count += dfsProcess(rowNum + 1, statusOfNextRow, cache);
            }
            res = Math.max(res, count);
        }
        cache[rowNum][statusOfCurRow] = res;
        return res;
    }

    //计算初始时，各行座位的状态
    private int[] compress(char[][] seats) {
        int[] res = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[i] |= seats[i][j] == '.' ? (1 << j) : 0;
            }
        }
        return res;
    }
}
