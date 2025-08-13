import java.util.*;
public class HUAWEI061803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //设备总量
        int n=sc.nextInt();
        //互斥设备数量
        int m=sc.nextInt();
        //指令数量
        int x=sc.nextInt();
        //互斥设备的编号列表
        boolean[] ban=new boolean[n];
        for(int i=0;i<m;i++){
            int banNum=sc.nextInt();
            ban[banNum]=true;
        }
        DSU dsu=new DSU(n,ban);
        int cnt=0;
        for(int i=0;i<x;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(!dsu.union(a,b)) cnt++;
        }
        //输出：被拒绝执行的指令条数
        System.out.println(cnt);
    }

    static class DSU{
        //节点的父节点
        int[] parent;
        //以该节点为根的树高
        int[] rank;
        int[] banCnt;
        DSU(int n,boolean[] ban){
            parent=new int[n];
            rank=new int[n];
            banCnt=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
                banCnt[i]=ban[i]?1:0;
            }
        }

        //返回x所在集合的根节点，并进行路径压缩
        int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]);
            return parent[x];
        }

        boolean union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            //已在同一集合，返回
            if(rootX==rootY) return true;
            //集合中互斥设备>1，拒绝
            if(banCnt[rootX]+banCnt[rootY]>1) return false;
            //按秩合并，秩小的树挂到大的树下
            if(rank[rootX]>rank[rootY]) {
                parent[rootY] = rootX;
                banCnt[rootX]+=banCnt[rootY];
            }
            else if(rank[rootX]<rank[rootY]) {
                parent[rootX] = rootY;
                banCnt[rootY]+=banCnt[rootX];
            }
            else{
                parent[rootY]=rootX;
                rank[rootX]++;
                banCnt[rootX]+=banCnt[rootY];
            }
            return true;
        }
    }
}
