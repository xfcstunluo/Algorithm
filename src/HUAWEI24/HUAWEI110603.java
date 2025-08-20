package HUAWEI24;
import java.util.*;
public class HUAWEI110603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一年中的月数
        int n = sc.nextInt();
        //连续登录的天数
        int x = sc.nextInt();
        int[] a=new int[n];
        int k=0;
        //每个月的天数
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            k+=a[i];
        }
        //金币数组
        long[] b=new long[2*k];
        int j=0;
        for(int i=0;i<n;i++){
            //a[i]为day，定义j=0，每个day循环里面money；for money in day
            int day=a[i];
            for(int money=1;money<=day;money++){
                b[j]=money;
                b[j+k]=money;
                j++;
            }
        }

        //每个月的第i天可以拿i个金币，连续登录可能会跨年
        //2n数组，滑动窗口取最大值,在窗口为x下的最大值
        int left=0,maxMoney=Integer.MIN_VALUE,ans=0;
        for(int right=0;right<2*k-1;right++){
            ans+=b[right];
            if(right-left+1==x){
                maxMoney=Math.max(maxMoney,ans);
                ans-=b[left];
                left++;
            }
        }
        System.out.println(maxMoney);

        //输出：新用户连续登录x天最多可以获得的金币数量
    }
}
