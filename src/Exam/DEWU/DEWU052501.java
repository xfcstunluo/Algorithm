package Exam.DEWU;

import java.util.*;
import java.util.stream.Collectors;

public class DEWU052501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans=0;
            List<Integer> list = new ArrayList<>();
            while(n-m>0){
                n-=m;
                ans++;
                list.add(m);
            }
            list.add(n);
            ans++;
            System.out.println(ans);
            Collections.sort(list);
            String result = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
