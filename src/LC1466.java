public class LC1466 {
    static int cnt = 0;

    public static void main(String[] args) {
        System.out.println(minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

    public static int minReorder(int n, int[][] connections) {
        dfs(connections, new boolean[n], 0);
        return cnt;
    }

    static void dfs(int[][] connections, boolean[] visited, int point) {
        visited[point] = true;

        for (int i = 0; i < connections.length; i++) {
            if (!visited[connections[i][0]] || !visited[connections[i][1]]) {
                if (connections[i][0] == point || connections[i][1] == point) {
                    if (connections[i][0] == point) {
                        cnt++;
                        dfs(connections, visited, connections[i][1]);
                    } else {
                        dfs(connections, visited, connections[i][0]);
                    }
                }
            }
        }
    }
}
