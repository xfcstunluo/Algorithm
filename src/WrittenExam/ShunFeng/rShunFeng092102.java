package WrittenExam.ShunFeng;

import java.util.*;

public class rShunFeng092102 {
    public static final int MOD=1000000007;
    public static long sum=0;
    public static int n;
    public static int m;
    public static int k;
    //    public static List<Integer> path=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //序列长度
        n = sc.nextInt();
        //序列中每个数字范围[1,m]
        m = sc.nextInt();
        //数字之间相差的阈值
        k = sc.nextInt();
        //除第一个数字外，与前一个数字相差不超过k/前一个数字整数倍
        //状态定义：dp[i][j]表示长度为i，最后一位为j时，构成方案数
        //状态转移：
        long[][] dp=new long[n+1][m+1];
        for(int j=1;j<=m;j++) dp[1][j]=1;
        for(int i=2;i<=n;i++){
            for(int v = 1; v <=m; v++){
                long sum=0;
                for(int u=1;u<=m;u++){
                    if(Math.abs(v-u)<=k||v%u==0){
                        sum+=dp[i-1][u];
                        //剪枝
                        if(sum>=MOD) sum-=MOD;
                    }
                }
                dp[i][v]=sum;
            }
        }

        long ans=0;
        for(int j=1;j<=m;j++){
            ans+=dp[n][j];
            if(ans>=MOD) ans-=MOD;
        }
        //输出：序列有几种构成方案
        System.out.println(ans);

    }
//    public static void dfs(int i,int lastJ){
//        if(i==n){
//            sum++;
//            return;
//        }
//        for(int j=1;j<=m;j++){
//            if(i!=0){
//                if(Math.abs(lastJ-j)<=k||j%lastJ==0){
//                    dfs(i+1,j);
//                }
//            }else{
//                dfs(i+1,j);
//            }
//        }
//    }

}
