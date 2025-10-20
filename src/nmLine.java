import java.util.*;
import java.util.stream.Collectors;

public class nmLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            //每个单元格填1个非零整数，使任意的2*2子网格中，四个单元格内整数之和=整个网格所有单元格内整数之和。
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    grid[i][j] = 1;
                }
            }
            for(int i = 0; i < n; i++) {
                System.out.println(Arrays.stream(grid[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
    }
}
