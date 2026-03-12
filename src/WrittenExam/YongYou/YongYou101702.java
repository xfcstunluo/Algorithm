package WrittenExam.YongYou;//背包问题，动态规划
import java.util.*;
public class YongYou101702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //业务员能力值workers[i]
        int[] workers = new int[n];
        //业务难度tasks[j]
        int[] tasks = new int[m];
        int sumWorkers = 0,sumTasks = 0;
        for (int i = 0; i < n; i++) {
            workers[i] = sc.nextInt();
            sumWorkers += workers[i];
        }
        for (int i = 0; i < m; i++) {
            tasks[i] = sc.nextInt();
            sumTasks += tasks[i];
        }
        if(sumWorkers<sumTasks){
            System.out.println("NO");
            return;
        }
        //m个任务二进制表示
        int totalMask=1<<m;

        int[] subsetSum=new int[totalMask];
        for(int mask=1;mask<totalMask;mask++){
            //取出mask中最右边的1
            int lowbit=mask & -mask;
            //末尾有几个0，lowbit对应的是第几个任务
            int bit=Integer.numberOfTrailingZeros(lowbit);
            //把mask的第lowbit位去掉，变成加值
            subsetSum[mask]=subsetSum[mask^lowbit]+tasks[bit];
        }

        //N个业务员匹配M项业务，业务员能力值不低于所承担业务的总难度
        //状态定义：dp[i][mask]前i个业务员，能否完成业务集合mask
        //状态转移：if(dp[i-1][mask]==true且sub不超过自身能力值) dp[i][mask|sub]=true
        //初始化数组：dp[0][0]=true
        boolean[][] dp=new boolean[n+1][totalMask];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            int capacity=workers[i-1];
            for(int mask=0;mask<totalMask;mask++){
                if(!dp[i-1][mask]) continue;
                //若前i-1个业务员能完成业务集合
                //当前业务员一个任务都不接
                dp[i][mask]=true;

                //接
                //枚举剩余任务结合
                int remain=((totalMask-1)^mask);
                for(int sub=remain;sub>0;sub=(sub-1)&remain){
                    if(subsetSum[sub]<=capacity) dp[i][mask|sub]=true;
                }
            }
        }
        //输出：可以全部分配输出yes，否则no
        System.out.println(dp[n][totalMask-1]?"YES":"NO");
    }
}
