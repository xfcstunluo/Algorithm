package Exam.DEWU;

import java.util.*;
public class DEWU090602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //街道长度
        int n = sc.nextInt();
        //连续长度
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //滑动窗口求最大值，若有多个最大值，记下标最小的输出
        //每当有最大值，记录下标，
        int l=0;
        int sum=0;
        int ans=Integer.MIN_VALUE;
        int index=-1;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            if(r-l+1>=k){
                if(sum>ans){
                    ans=sum;
                    index=l+(r-l)/2+1;
                }
                sum-=arr[l];
                l++;
            }
        }
        System.out.println(index);
    }
}
