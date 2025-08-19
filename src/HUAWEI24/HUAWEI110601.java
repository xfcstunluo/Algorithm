package HUAWEI24;
import java.util.*;
public class HUAWEI110601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //相同发送源发送的包序列号不重复，且序列号每次+1；如果不满足，必然来自其它发送源
        //1 2 3 4 5 6 7 8 9 10 10
        //1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Map<Integer,Integer> m=new HashMap<>();
        int ans=0;
        for(int x:a){
            //所有value++
            //若x-1不在map中，新建一个key；若在，x-1对应的value-1，同时x的值+1
            if(m.getOrDefault(x-1,0)==0){
                ans++;
            }else{
                m.put(x-1,m.get(x-1)-1);
            }
            m.put(x,m.getOrDefault(x,0)+1);
        }
        System.out.println(ans);
        //将当前的数字x接到以前以x-1结尾的递增序列后面；
        //递增，且不能重复
        //输出：最少的发送源个数
    }
}

