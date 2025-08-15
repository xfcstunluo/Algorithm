package HUAWEI24;
import java.util.*;
public class HUAWEI111301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //定时器系统容量
        int n = sc.nextInt();
        //定时任务数
        int m = sc.nextInt();
        //先按顺序添加，当n饱和时，如果后续的数大于最后一个加入的数，丢弃，反之丢弃数组中最大的数，加入新数
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return b[0]-a[0];
            else return b[1]-a[1];
        });
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            if(q.size()<n) q.offer(new int[]{a,i});
            else{
                if(q.peek()[0]<a) continue;
                else if(q.peek()[0]==a&&q.peek()[1]<i){
                    q.poll();
                    q.offer(new int[]{a,i});
                }else{
                    q.poll();
                    q.offer(new int[]{a,i});
                }
            }
        }
        int maxValue=q.peek()[1];
        System.out.println(maxValue);
    }
}
