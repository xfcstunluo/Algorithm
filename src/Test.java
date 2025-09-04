import java.util.ArrayDeque;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int ans = numIslands(grid);
        System.out.println(ans);
    }

    public static int[][] Mapping = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numIslands(char[][] grid) {
        //dfs,当遇到0时返回，每次开始前ans++；
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            q.offer(new int[]{i, j});
            ans++;
            //出队，
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int a = cur[0], b = cur[1];
                visited[a][b] = true;
                for (int k = 0; k < 4; k++) {
                    int x = a + Mapping[k][0], y = b + Mapping[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == '1')
                        q.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }
}