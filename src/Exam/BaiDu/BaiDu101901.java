package Exam.BaiDu;

import java.util.*;
//令人心动的极差
public class BaiDu101901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minV=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            pq.add(num);
            minV = Math.min(minV,num);
        }
        //定位到最大值和最小值，每次平均瓜分最大值；
        int maxV=pq.poll(),ans=0;
        while(minV*2<maxV){
            ans++;
            int num1=maxV/2;
            int num2=maxV-num1;
            pq.add(num1);
            pq.add(num2);
            if(num1<minV) minV=num1;
            if(num2<minV) minV=num2;
            maxV=pq.poll();
        }



        //输出：将数组变为心动数的最少操作次数
        System.out.println(ans);
    }
}
