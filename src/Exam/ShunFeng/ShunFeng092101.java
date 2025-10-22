package Exam.ShunFeng;

import java.util.*;
//前缀和+二分
public class ShunFeng092101 {
    //两个长度为n的数组，其中a和b相乘得到新数组，询问新数组[l,r]的和。
    //a=[8,7,5,7],b=[2,2,1,3],new=[8,8,7,7,5,7,7,7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数组长度；
        int n = sc.nextInt();
        //数组a
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }
        //数组b
        long[] b=new long[n];
        for(int i=0;i<n;i++){
            b[i]=sc.nextLong();
        }
        //前缀位置下标
        long[] prefCnt=new long[n];
        //前缀总和
        long[] prefSum=new long[n];
        for(int i=0;i<n;i++){
            prefCnt[i]=(i==0?0:prefCnt[i-1])+b[i];
            prefSum[i]=(i==0?0:prefSum[i-1])+a[i]*b[i];
        }
        int T=sc.nextInt();
        while(T-->0){
            long l=sc.nextLong();
            long r=sc.nextLong();
            int rangeL=lowerBound(prefCnt,l);
            int rangeR=lowerBound(prefCnt,r);
            long ans=0;
            if(rangeL==rangeR) ans=(r-l+1)*a[rangeL];
            else{
                //左残余块+中间块+右残余块
                //左残余块：从l开始到第rangeL块覆盖结束
                long left=(prefCnt[rangeL]-l+1)*a[rangeL];
                //右残余块：从rangeR块开始到第r块覆盖结束
                long right=(r-prefCnt[rangeR-1]+1)*a[rangeR];
                long mid=0;
                if(rangeR-rangeL>1){
                    mid=prefSum[rangeR-1]-prefSum[rangeL];
                }
                ans=left+mid+right;
            }
            System.out.println(ans);
        }
    }
    public static int lowerBound(long[] preCnt,long t){
        int l=0,r=preCnt.length-1,ans=0;
        while(l<=r){
            int m=l+(r-l)/2;
            if(preCnt[m]<t){
                l=m+1;
                ans=m;
            }else r=m-1;
        }
        return ans;
    }
}
