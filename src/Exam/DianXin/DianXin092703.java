package Exam.DianXin;

import java.util.*;
public class DianXin092703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            //字符串长度
            int n = sc.nextInt();
            sc.nextLine();
            String str=sc.nextLine();
            char[] s=str.toCharArray();
            int ans=0;
            int bal=0;
            for(char c:s){
                if(c=='(') bal++;
                else bal--;
                if(bal<0){
                    //需要从后面搬来交换的（数+1；
                    ans++;
                    bal=1;
                }
            }
            System.out.println(ans);
        }

    }
}
