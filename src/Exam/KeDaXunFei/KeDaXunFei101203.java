package Exam.KeDaXunFei;

import java.util.*;
public class KeDaXunFei101203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //改变某一个数，使之成为495的倍数，不许出现前导0，计算最少需要改变的位数，并给出改变后的数
        long n = sc.nextLong();
        if(n%495==0){
            System.out.println(0);
            System.out.println(n);
            return;
        }else{
            //检查这个数是几位，统计495*n在这个位中的上下限，循环比较
            String s=Long.toString(n);
            int digit=s.length();
            long max=(long)Math.pow(10,digit)-1;
            long min=(long)Math.pow(10,digit-1);
            long goodMin=(min+495-1)/495;
            long goodMax=max/495;
            long ans=Long.MAX_VALUE;
            long ansNum=n;
            String strN=Long.toString(n);
            //枚举所有dight位的495的倍数，统计与n的逐位差异，取最小
            for(long i=goodMin;i<=goodMax;i++){
                long diff =0;
                long cur=495L*i;
                String str=Long.toString(cur);
                for(int j=0;j<str.length();j++){
                    if(str.charAt(j)!=strN.charAt(j)){
                        diff++;
                    }
                }
                if(diff <ans){
                    ans= diff;
                    ansNum=cur;
                }
            }
            System.out.println(ans);
            System.out.println(ansNum);
        }
    }
}
