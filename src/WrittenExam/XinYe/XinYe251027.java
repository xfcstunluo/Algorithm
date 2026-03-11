package WrittenExam.XinYe;

import java.util.*;
public class XinYe251027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //边的条数
        int n=sc.nextInt();
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{sc.nextInt(),sc.nextInt()});
        }
        int[][] dependencyChain=list.toArray(new int[list.size()][]);
        List<List<Integer>> result=getAllAncestors(n,dependencyChain);
        System.out.println(result);
    }

    public static List<List<Integer>> getAllAncestors(int m,int[][] dependencyChain){
        //构建邻接表
        List<Integer>[] graph=new ArrayList[m];
        for(int i=0;i<m;i++){
            graph[i]=new ArrayList<>();
        }

        //入度数组
        int[] indegree=new int[m];
        for(int[] edge:dependencyChain){
            int src=edge[0];
            int des=edge[1];
            //邻接表
            graph[src].add(des);
            //入度
            indegree[des]++;
        }

        //每个节点用位图维护祖先集合，创新点在位图用位或特别快
        BitSet[] ancestor=new BitSet[m];
        for(int i=0;i<m;i++){
            ancestor[i]=new BitSet(m);
        }

        //拓扑排序，入度为0的节点先进队
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            if(indegree[i]==0) q.offer(i);
        }

        //从入度0点开始，沿有向边向后传播祖先节点
        while(!q.isEmpty()){
            int v=q.poll();
            //如果v是u的祖先，则v的祖先也是u的祖先
            for(int u:graph[v]){
                ancestor[u].or(ancestor[v]);
                ancestor[u].set(v);
                if(--indegree[u]==0) q.offer(u);
            }
        }

        //BitSet转换为升序列表
        List<List<Integer>> result=new ArrayList<>(m);
        for(int i=0;i<m;i++){
            List<Integer> list=new ArrayList<>();
            for(int bit=ancestor[i].nextSetBit(0);bit>=0;bit=ancestor[i].nextSetBit(bit+1)) {
                list.add(bit);
            }
            result.add(list);
        }
        return result;
    }
}

//9
//0 3 0 4 1 3 2 4 2 7 3 5 3 6 3 7 4 6