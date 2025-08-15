package HUAWEI25;

import java.util.*;
import java.util.stream.Collectors;

public class HUAWEI040902 {
    static int[][] edges;
    static int minCost=Integer.MAX_VALUE;
    static List<Integer> res=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str=sc.nextLine().split(" ");
        int start=str[0].charAt(0) - 'a';
        int end=str[1].charAt(0) - 'a';
        edges=new int[n][n];
        while(true){
            String s=sc.nextLine();
            if(s.equals("0000")) break;
            String[] arr=s.split(" ");
            int u=arr[0].charAt(0)-'a';
            int v=arr[1].charAt(0)-'a';
            int w=Integer.parseInt(arr[2]);
            edges[u][v]=w;
            edges[v][u]=w;
        }
        List<Integer> path=new ArrayList<>();
        path.add(start);
        dfs(start,end,0,path);
        List<Character> ans=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            int ch=res.get(i);
            ans.add((char)(ch+'a'));
        }
        System.out.println(ans.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void dfs(int u,int v,int cost,List<Integer> path){
        if(cost>minCost) return;
        if(u==v&&cost<minCost){
            res=new ArrayList<>(path);
            minCost=cost;
            return;
        }
        for(int i=0;i<edges.length;i++){
            if(edges[u][i]!=0&&!path.contains(i)){
                cost+=edges[u][i];
                path.add(i);
                dfs(i,v,cost,path);
                cost-=edges[u][i];
                path.remove(path.size()-1);
            }
        }
    }
}
