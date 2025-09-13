package writtenExam.MeiTuan;

import java.util.*;
public class MeiTuan091303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n个节点，初始都是白色，q次操作。
        //u，v路径上的所有点都染红；
        //节点数
        int n = sc.nextInt();
        //操作次数
        int q = sc.nextInt();
        int[][] color= new int[n][n];
        for(int i = 1; i <n; i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            color[u-1][v-1]=1;
            color[v-1][u-1]=1;
        }
        List<int[]> colorList = new ArrayList<>();
        for(int i = 1; i <=q; i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            colorList.add(new int[]{u,v});
        }
        //取出u，v，从u到v的路线上经历的所有节点都要=2；


        //输出：多少个红色连通块？岛屿（任意两个顶点有边相连，）
    }
}
