package Exam.KeDaXunFei;

import java.util.*;
import java.util.stream.Collectors;

public class KeDaXunFei101201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s=sc.nextLine();
            char[] str=s.toCharArray();
            //下标从1开始，ai为在i左侧，字符与si不同的元素个数
            List<Integer> a = new ArrayList<>();
            int sum0=0,sum1=0;
            for(int i = 0; i < n; i++){
                if(str[i]=='0'){
                    a.add(sum1);
                    sum0++;
                }else{
                    a.add(sum0);
                    sum1++;
                }
            }
            //输出：整个a序列
            System.out.println(a.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
