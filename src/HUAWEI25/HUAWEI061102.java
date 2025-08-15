package HUAWEI25;

import java.util.*;
public class HUAWEI061102 {
    //邻接表，出度数组，父节点编号数组，节点深度
    //邻接表有两种创建方式；
    static List<List<Integer>> matrix;
    static int n;
    static int[] out;
    static int[] par;
    static int[] dep;
    static List<Integer> sleave;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        matrix=new ArrayList<>();
        n=sc.nextInt();
        for(int i=0;i<=n;i++){
            matrix.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            matrix.get(u).add(v);
            matrix.get(v).add(u);
        }
        out=new int[n+1];
        par=new int[n+1];
        dep=new int[n+1];
        sleave=new ArrayList<>();
        //从根节点开始，u=1，父节点为0，深度为0；
        dfs(1,0,0);

        int ans=Integer.MAX_VALUE;
        for(int d=1;d<n;d++){
            ans=Math.min(ans,bfs(d));
        }
        System.out.println(ans);
    }

    //节点本身，父节点，深度
    static void dfs(int u,int p,int d){
        //记录当前节点的父节点、深度
        par[u]=p;
        dep[u]=d;
        for(int v:matrix.get(u)){
            //避免走回父节点
            if(v==p) continue;
            dfs(v,u,d+1);
            //记录出度
            out[u]++;
        }
        if(out[u]==0) sleave.add(u);
    }

    //只要目标深度不是d就删掉
    static int bfs(int d){
        Deque<Integer> q=new ArrayDeque<>(sleave);
        int[] outCopy=Arrays.copyOf(out,n+1);
        int sum=0;
        while(!q.isEmpty()){
            int v=q.poll();
            if(dep[v]==d) continue;
            outCopy[par[v]]--;
            sum++;
            if(outCopy[par[v]]==0) q.offer(par[v]);
        }
        return sum;
    }
}
