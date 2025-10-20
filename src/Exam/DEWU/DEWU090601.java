package Exam.DEWU;

import java.util.*;
public class DEWU090601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //砖块堆数
        int n = sc.nextInt();
        //手动搬1块砖所需时间
        int x = sc.nextInt();
        //开车搬1堆所需时间
        int y = sc.nextInt();
        //卡车搬运次数
        int k = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            a.add(sc.nextInt());
        }
        //贪心，排序之后，最大的用卡车时间代替；直到卡车次数耗尽
        Collections.sort(a);
        long sum = 0;
        //整型溢出
        for(int i=0;i<n-k;i++){
            sum+=(long)a.get(i)*x;
        }
        for(int i=n-k;i<n;i++){
            long hand = (long)a.get(i) * x;
            sum += Math.min(hand,y);
        }
        System.out.println(sum);
        //输出：全部砖块搬到b处所需最少时间
    }
}
