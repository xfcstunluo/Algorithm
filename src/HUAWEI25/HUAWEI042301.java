package HUAWEI25;

import java.util.*;
import java.util.stream.Collectors;
public class HUAWEI042301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //图像宽度
        int w = sc.nextInt();
        //图像高度
        int h = sc.nextInt();
        //给定亮度值
        int m = sc.nextInt();
        //需要输出的亮度值为m的坐标个数
        int k = sc.nextInt();
        //返回离图像中心坐标最近的k个亮度为m的坐标,三个参数，1.距离，2.x轴，3。y轴
        int centerX=(w-1)/2,centerY=(h-1)/2;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            else return a[2]-b[2];
        });
        int[][] edges=new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                edges[i][j]=sc.nextInt();
                if(edges[i][j]==m){
                    int distance=Math.abs(j-centerX)+Math.abs(i-centerY);
                    heap.add(new int[]{distance,j,i});
                }
            }
        }
        //输出 x坐标不同时，以x升序排列，相同时以y升序排列；若满足调节的坐标数量不足k，以实际数量输出
        //优先队列
        List<Integer> list=new ArrayList<>();
        if(heap.size()<k){
            int cur=heap.size();
            for(int i=0;i<cur;i++){
                int[] num=heap.poll();
                int x=num[1];
                int y=num[2];
                list.add(x);
                list.add(y);
            }
            System.out.println(list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }else{
            for(int i=0;i<k;i++){
                int[] num=heap.poll();
                int x=num[1];
                int y=num[2];
                list.add(x);
                list.add(y);
            }
            System.out.println(list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }

    }
}
