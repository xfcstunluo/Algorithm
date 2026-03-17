package WrittenExam.YongYou;

import java.util.*;
public class YongYou101703 {
    public static ArrayList<Integer>[] rev;
    public static boolean[] inCycle;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n位员工参加表演
        int n = sc.nextInt();
        //第i个员工的搭子
        int[] to=new int[n];
        rev=new ArrayList[n];
        for(int i=0;i<n;i++){
            rev[i]=new ArrayList<>();
        }

        //每个员工必须选择一位搭子，只有其在搭子左侧或右侧时，才可被选中参与表演，表演必须围成圈
        //统计每个员工被哪些人选为搭子
        int[] indeg=new int[n];
        for(int i=0;i<n;i++){
            to[i]=sc.nextInt();
            rev[to[i]].add(i);
            indeg[to[i]]++;
        }

        inCycle=new boolean[n];
        Arrays.fill(inCycle,true);

        //要围城最大的圈，就找其中最大的环，或者所有2环及其两边最长链的贡献之和
        //拓扑剥叶，留下环
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int u=q.poll();
            inCycle[u]=false;
            int v=to[u];
            indeg[v]--;
            if(indeg[v]==0) q.offer(v);
        }
        //找所有环
        boolean[] visCycle=new boolean[n];
        int maxCycle=0;
        int sumPairChains=0;
        for(int i=0;i<n;i++){
            //当该点在环内并且没被遍历过
            if(inCycle[i]&&!visCycle[i]){
                List<Integer> cycle=new ArrayList<>();
                int cur=i;
                //找出这个环
                while(!visCycle[cur]){
                    visCycle[cur]=true;
                    cycle.add(cur);
                    cur=to[cur];
                }
                int size=cycle.size();
                //若当环的长度为2，可以与其它为2的环无限拼接，最后不影响围成圈
                if(size==2){
                    int u=cycle.get(0);
                    int v=cycle.get(1);
                    int left=longestChain(u,v);
                    int right=longestChain(v,u);
                    sumPairChains+=left+right+2;
                }else{
                    maxCycle=Math.max(maxCycle,size);
                }
            }
        }
        //输出：能参加表演最多的人数
        System.out.println(Math.max(maxCycle,sumPairChains));
    }

    //求指向root的最长链长度，不能走环上的其它节点，不能走ban
    public static int longestChain(int root,int ban){
        int best=0;
        for(int pre:rev[root]){
            if(pre==ban||inCycle[pre]) continue;
            best=Math.max(best,dfs(pre));
        }
        return best;
    }

    //求最大深度
    public static int dfs(int u){
        //当前节点算1
        int best=1;
        for(int pre:rev[u]){
            if(inCycle[pre]) continue;
            best=Math.max(best,dfs(pre)+1);
        }
        return best;
    }
}
