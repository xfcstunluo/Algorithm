package Exam.MeiTuan;

import java.util.*;
import java.util.stream.Collectors;

//直接用数组，不用双端队列
public class MeiTuan091302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //两个长度都为n的数组a，b，对两个数组进行任意重排为a‘，b’，记di=a'i-b'i;
        //对所有的i，满足di等于小于左右两边的数/等于大于左右两边的数
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a= new int[n];
            int[] b= new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                b[i] = sc.nextInt();
            }
            //一个按小大小大···，一个按大小大小···，分别用双端队列
            Arrays.sort(a);
            Arrays.sort(b);
            Deque<Integer> aq = new ArrayDeque<>();
            Deque<Integer> bq = new ArrayDeque<>();
            for(int i = 0; i < n; i++){
                aq.add(a[i]);
                bq.add(b[i]);
            }
            //对a重排列：大小大小
            for(int i = 0; i < n; i++){
                if(i%2==0) {
                    a[i] = aq.pollLast();
                    b[i] = bq.pollFirst();
                }
                else{
                    a[i] = aq.pollFirst();
                    b[i] = bq.pollLast();
                }
            }
            List<Integer> alist=new ArrayList<>();
            List<Integer> blist=new ArrayList<>();
            for(int i = 0; i < n; i++){
                alist.add(a[i]);
                blist.add(b[i]);
            }
            System.out.println(alist.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            System.out.println(blist.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        //输出：任意一组满足的重排后的数组a‘，b’
    }
}
