package WrittenExam.Tiger;
import java.util.*;
public class transaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //每个客户每天若干笔流水，正数入金，负数出金；
        //统计账户一天内，连续交易窗口内(窗口大小为1~k)最大资金占用，即净资金最大流
        String str = sc.nextLine();
        String[] s=str.substring(1,str.length()-3).split(", ");
        char numStr=str.charAt(str.length()-1);
        int k=numStr-'0';
        int n=s.length;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(s[i]);
        }
        int ans=Integer.MIN_VALUE;
        int l=0,sum=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            if(r-l+1>=k){
                ans=Math.max(ans,sum);
                sum-=nums[l];
                l++;
            }else{
                ans=Math.max(ans,sum);
            }
        }

        //输出：净资金最大值
        System.out.print(ans);
    }
}
