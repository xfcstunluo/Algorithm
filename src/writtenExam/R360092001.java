package writtenExam;

import java.util.*;
public class R360092001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //起步价
        int a = sc.nextInt();
        //单价
        int b = sc.nextInt();
        //起步价对应的分钟数
        int c = sc.nextInt();
        //所处位置到景点的路的段数
        int n= sc.nextInt();
        //每段路需要的分钟数
        int[] needTimes =new int[n];
        for(int i=0;i<n;i++){
            needTimes[i]=sc.nextInt();
        }
        //路与路之间等待时间
        int[] waitTimes =new int[n-1];
        for(int i=0;i<n-1;i++){
            waitTimes[i]=sc.nextInt();
        }
        //a+b(x-c)=
        //状态定义：dp[i]为第i分钟时，所需付钱的最小值;x表示当前已行驶分钟数
        //状态转移：dp[i]=dp[i-1]+min(下车，不下车) min(a+dp[i-1],)


        //输出：所需付钱的最小值
    }
}

//7 1 5
//        4
//        6 7 5 8
//        1 11 1
//
//32
