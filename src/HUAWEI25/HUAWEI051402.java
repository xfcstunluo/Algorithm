package HUAWEI25;

import java.util.*;
public class HUAWEI051402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>100||n<0){
            System.out.println("-2");
            return;
        }
        int[][] map=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]=sc.nextInt();
                if(map[i][j]<0||map[i][j]>10){
                    System.out.println("-2");
                    return;
                }
            }
        }
        //状态定义：cost[i,j]从0，0->i，j的最小消耗；
        //状态转移：①同一行cost[i,j]=cost[i,j-1]+edge[i,j];②同一列cost[i,j]=cost[i-1,j]+edge[i,j];
        //附加条件：高度差不能超过1；abs(edge[i,j]-cost[上一个])<=1;
        final int INF=1000000000;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],INF);
        }
        dp[0][0]=map[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>0&&Math.abs(map[i][j]-map[i-1][j])<=1){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+map[i][j]);
                }
                if(j>0&&Math.abs(map[i][j]-map[i][j-1])<=1){
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+map[i][j]);
                }
            }
        }
        int ans=INF;
        for(int i=0;i<n;i++){
            if(dp[i][n-1]!=INF) ans=Math.min(ans,dp[i][n-1]);
        }
        System.out.println(ans==INF?-1:ans);
    }
}
