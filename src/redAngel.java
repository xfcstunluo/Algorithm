import java.util.*;
public class redAngel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //改变某一个数，使之成为495的倍数，不许出现前导0，计算最少需要改变的位数，并给出改变后的数
        long n = sc.nextLong();
        if(n%495==0){
            System.out.println(0);
            System.out.println(n);
        }else{
            //检查这个数是几位，统计495*n在这个位中的上下限，循环比较
            long tmp=n,sum=0;
            while(tmp/10!=0||tmp%10!=0){
                sum++;
                tmp=tmp/10;
            }
            long max=(long)Math.pow(10,sum)-1;
            long min=(long)Math.pow(10,sum-1);
            long goodMin=min/495+1;
            long goodMax=max/495;
            long ans=Long.MAX_VALUE;
            long ansNum=n;
            String strN=Long.toString(n);
            for(long i=goodMin;i<=goodMax;i++){
                long tmpAns=0;
                long cur=495*i;
                String str=Long.toString(cur);
                for(int j=0;j<str.length();j++){
                    if(str.charAt(j)!=strN.charAt(j)){
                        tmpAns++;
                    }
                }
                if(tmpAns<ans){
                    ans=tmpAns;
                    ansNum=cur;
                }
            }
            System.out.println(ans);
            System.out.println(ansNum);
        }
    }
}
