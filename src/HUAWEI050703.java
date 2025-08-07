import java.util.*;
public class HUAWEI050703 {
    static int[][] Mapping={{1,0},{0,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        //左上角的车往右或下移动，右下角往左或者上移动；
        //状态定义：dp[i][j]表示在i,j点的最小代价
        //状态转移：①dp[i][j]=dp[i][j-1]+grid[i][j]；②dp[i][j]=dp[i-1][j]+grid[i][j];
        //fp[i][j]=fp[i][j+1]+grid[i][j]; ②fp[i][j]=fp[i+1][j]+grid[i][j]
        //初始化数组；边界条件；
        //附加条件：grid[i][j]=0无法通过；
        int[][] dp = new int[n][n];
        int[][] fp= new int[n][n];
        int INF=1000000000;
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], INF);
            Arrays.fill(fp[i], INF);
        }
        dp[0][0] = grid[0][0];
        fp[n-1][n-1] = grid[n-1][n-1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i>0&&grid[i][j]!=0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+grid[i][j]);
                }
                if(j>0&&grid[i][j]!=0){
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i<n-1&&grid[i][j]!=0){
                    fp[i][j]=Math.min(fp[i][j],fp[i+1][j]+grid[i][j]);
                }
                if(j<n-1&&grid[i][j]!=0){
                    fp[i][j]=Math.min(fp[i][j],fp[i][j+1]+grid[i][j]);
                }
            }
        }
        //以dp为坐标，算最小的相邻和,无法相遇返回-1
        //无法相遇：minCost一直是INF？
        int minCost=INF;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int[] map:Mapping){
                    int x=i+map[0];
                    int y=j+map[1];
                    if(x>=0&&x<n&&y>=0&&y<n&&dp[i][j]<INF&&fp[x][y]<INF){
                        minCost=Math.min(minCost,Math.max(dp[i][j],fp[x][y]));
                    }
                }
            }
        }
        System.out.println(minCost==INF?-1:minCost);
    }
}
