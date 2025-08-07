import java.util.*;
import java.util.stream.Collectors;


public class HUAWEI052801 {
    //数组展示每个路口/基站连接的用户数量，基站覆盖范围
    //0号到1号为0号路段，n个路口只有n-1个路段；输出也是n-1个路段；
    //滑动窗口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(" ");
        int n=arr.length;
        int[] crossroads=new int[n];
        for(int i=0;i<n;i++){
            crossroads[i]=Integer.parseInt(arr[i]);
        }
        //3 5 8 7 6 7 4
        //从某个索引开始，前后k个，当索引不超过0和n-1的时候，队头出，队尾进
        //双端队列+单调队列
        //路段 i覆盖[i-k,i+k] i~i+1：i
        //路段s：[s,s+1]路段要在基站i覆盖的范围内
        //i-k<=s,s+1<=i+k;
        //s:[i-k,i+k-1]
        //i<=s+k,s+1-k<=i;
        //i:[s-k+1,s+k] i能覆盖字段s
        int k=sc.nextInt();
        if(crossroads.length==1){
            System.out.println(0);
            return;
        }
        int[] res=new int[n-1];
        Deque<Integer> q=new ArrayDeque<>();
        int right=-1;
        for (int s=0;s<n-1;s++){
            int left=Math.max(0,s-k+1);
            int newRight=Math.min(n-1,s+k);
            for(int j=right+1;j<=newRight;j++){
                while(!q.isEmpty()&&crossroads[q.peekLast()]>=crossroads[j]) q.pollLast();
                q.offer(j);
            }
            right=newRight;
            while(!q.isEmpty()&&q.peek()<left) q.poll();
            res[s]=q.peek();
        }
        String result=Arrays.stream(res)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);

    }
}
