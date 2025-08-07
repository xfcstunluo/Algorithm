import java.util.*;
import java.util.stream.Collectors;

public class HUAWEI052802 {
    //景点个数
    //N*N矩阵
    //景点是否是出入口
    //以入口+出口计算最短路径，路程最短
    //3
    //0 2 4
    //2 0 3
    //4 3 0
    //1 0 1
    //0 2
    //dfs+剪枝
    static List<List<Integer>> minPathList=new ArrayList<>();
    static int minPath=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edge=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                edge[i][j]=sc.nextInt();
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int[] arr=new int[2];
        arr[0]=sc.nextInt();
        arr[1]=sc.nextInt();
        List<Integer> path=new ArrayList<>();
        path.add(arr[0]);
        dfs(arr[0],arr[1],path,0,edge);
        minPathList.sort((a,b)->{
            for(int i=0;i<Math.min(a.size(),b.size());i++){
                if(!a.get(i).equals(b.get(i))){
                    return Integer.compare(a.get(i),b.get(i));
                }
            }
            return Integer.compare(a.size(),b.size());
        });

        for(List<Integer> l:minPathList){
            System.out.println(
                    l.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "))
            );
        }


    }

    public static void dfs(int u,int e,List<Integer> path,int cost, int[][] edge){
        int n=edge.length;
        //剪枝
        if(cost>minPath){
            return;
        }
        if(u==e){
            //判断cost是否比minPath小，是更新minPath
            //如果等于minPath，minPath.add
            if(cost<minPath){
                minPath=cost;
                minPathList.clear();
                minPathList.add(new ArrayList<>(path));
            }else if(cost==minPath){
                minPathList.add(path);
            }
            return;
        }
        for(int v=0;v<n;v++){
            if(edge[u][v]!=0&&!path.contains(v)){
                path.add(v);
                dfs(v,e,path,cost+edge[u][v],edge);
                path.remove(path.size()-1);
            }
        }
    }
}


