import java.util.*;
import java.util.stream.Collectors;

public class HUAWEI050701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //行驶距离最近的k个充电桩数量
        int k = sc.nextInt();
        //充电桩总数量
        int n = sc.nextInt();
        if(k==0||k>n){
            System.out.println("null");
            return;
        }
        //汽车的位置坐标
        long carX=sc.nextInt();
        long carY=sc.nextInt();
        List<long[]> charge=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            charge.add(new long[]{x,y,i});
        }
        //堆？
        PriorityQueue<long[]> heap=new PriorityQueue<>((a,b)->{
            if(a[3]!=b[3]) return Long.compare(a[3],b[3]);
            else return Long.compare(a[0],b[0]);
        });
        for(long[] h:charge) {
            long result=Math.abs(h[0]-carX)+Math.abs(h[1]-carY);
            //当堆不为空，并且结果比堆顶小的时候才入堆
            heap.offer(new long[]{h[2],h[0],h[1],result});
        }
        //输出：充电桩编号、充电坐标x,y\、汽车到充电桩的行驶距离distance；
        //按距离从小到大排序，距离相等按照充电桩编号从小到大输出；
        //k=0/>n;输出null
        for(int i=1;i<=k;i++){
            System.out.println(Arrays.stream(heap.poll())
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }
}
