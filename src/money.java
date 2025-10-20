import java.util.*;
public class money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //月份
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        //不能连续两月储蓄，储蓄总金额至少达到target，且储蓄的月份尽可能少；
        int[] dp=new int[n+1];
        int[] monthNum=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;
        dp[1]=nums[0];
        monthNum[1]=1;
        int i=1;
        for(;i<n;i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
            if(dp[i+1]==dp[i-1]+nums[i]){
                monthNum[i+1]=monthNum[i-1]+1;
            }else monthNum[i+1]=monthNum[i];
            if(dp[i+1]>=target) break;
        }
        //输出：最少储蓄月数，无法达到输出-1；
        if(dp[i-1]<target) System.out.println(-1);
        else System.out.println(monthNum[i+1]);
    }
}
