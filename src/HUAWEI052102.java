import java.util.*;
public class HUAWEI052102 {
    static int minLen=Integer.MAX_VALUE;
    public static void main(String[] args) {
        //物质节点到受灾乡镇的最短线路
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edge=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                edge[i][j]=sc.nextInt();
            }
        }
        int aim=sc.nextInt();
        //bfs
        //到目标节点aim最短。求有权值的最短路径；dfs
        List<Integer> path=new ArrayList<>();
        dfs(0,edge,aim,0,path);
        System.out.println(minLen);

    }
    public static void dfs(int u,int[][] edge,int aim,int cost,List<Integer> path){
        if(cost>minLen){
            return;
        }
        if(u==aim){
            minLen=Math.min(minLen,cost);
            return;
        }
        int n=edge.length;
        for(int v=0;v<n;v++){
            if(edge[u][v]!=0&&!path.contains(v)){
                path.add(v);
                dfs(v,edge,aim,cost+edge[u][v],path);
                path.remove(path.size()-1);
            }
        }
    }
}
