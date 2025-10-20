package writtenExam.DiDi;

import java.util.*;

public class DiDi092701new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //[a,b]表示应当考虑的进制区间
        int a = sc.nextInt();
        int b = sc.nextInt();
        //[l,r]询问的数字区间
        int l = sc.nextInt();
        int r = sc.nextInt();
        //波浪数的重数
        int k = sc.nextInt();
        int lenRange=r-l+1;
        int[] counts=new int[lenRange];
        for(int B=a;B<=b;B++){
            //当前进制下，不超过r的数的最大位数
            int maxLen=1;
            long pw=B;
            while(pw<=r){
                maxLen++;
                if(pw*B>(long)r) break;
                pw*=B;
            }
            //当前进制下已经确定为波浪数的值
            HashSet<Integer> set=new HashSet<>();
            //只有一位的数字
            for(int m=1;m<B;m++){
                if(m>=l&&m<=r) set.add(m);
            }
            //>=2的波浪数
            for(int len=2;len<=maxLen;len++){
                //枚举首位x和第二位y
                for(int x = 1; x <B; x++){
                    for(int y=0;y<B;y++){
                        if(x==y) continue;

                    }
                }
            }
        }
    }
}
