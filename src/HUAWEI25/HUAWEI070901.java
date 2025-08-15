package HUAWEI25;

import java.util.*;
public class HUAWEI070901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int area=sc.nextInt();
        //总预算，为10的整数倍
        int budget=sc.nextInt()/10;
        //接入点数量
        int n=sc.nextInt();
        List<int[]> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int coverage=sc.nextInt();
            //为10的整数倍
            int cost=sc.nextInt();
            arr.add(new int[]{coverage,cost/10});
        }
        //背包
        //满足area的情况下，找预算最小；相同预算最小的情况下，找覆盖面积最大
        //状态定义：dp[i]表示预算为i时，可以达到的最大面积；
        //状态转移：dp[i]=max(dp[i-cost]+coverage,dp[i]);//选不选这个接入点
        //初始化+边界条件；
        int[] dp=new int[budget+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int[] a:arr){
            int coverage=a[0];
            int cost=a[1];
            for(int i=budget;i>=cost;i--){
                dp[i]=Math.max(dp[i],dp[i-cost]+coverage);
            }
        }
        boolean flag=false;
        int bestCoverage=0;
        int bestCost=0;
        for(int i=0;i<=budget;i++){
            if(dp[i]>=area){
                bestCost=i;
                bestCoverage=dp[i];
                flag=true;
                break;
            }
        }
        System.out.println(flag?bestCost*10+" "+bestCoverage:"0 0");
    }
}
