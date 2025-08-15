package HUAWEI24;
import java.util.*;
public class HUAWEI111301Foreign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //游客数量
        int m = sc.nextInt();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            q.add(new int[]{a,b});
        }
        int[] arr = q.poll();
        List<int[]> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int[] num=q.poll();
            if(arr[1]>=num[0]){
                if(arr[1]<num[1]){
                    arr[1]=num[1];
                }
            }else{
                int[] newArr=Arrays.copyOf(arr,arr.length);
                list.add(newArr);
                arr[0]=num[0];
                arr[1]=num[1];
            }
        }
        list.add(arr);
        //输出：景点接待客户总时长，同一时刻内可接多名游客。
        int result=0;
        for(int i=0;i<list.size();i++){
            int[] res=list.get(i);
            result+=(res[1]-res[0]);
        }
        System.out.println(result);
    }
}
