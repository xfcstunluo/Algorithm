import java.util.*;
public class HUAWEI061101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        List<int[]>[] matrix = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            matrix[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int c=sc.nextInt();
            matrix[u].add(new int[]{v,c});
            matrix[v].add(new int[]{u,c});
        }
        Set<Integer> s=new HashSet<>();
        Set<Integer> t=new HashSet<>();
        for(int i=0;i<M;i++){
            int ss=sc.nextInt();
            int tt=sc.nextInt();
            s.add(ss);
            t.add(tt);
        }
        int slen=dfs(1,-1,s,matrix);
        int tlen=dfs(1,-1,t,matrix);
        System.out.println(slen+tlen);

    }
    public static int dfs(int u,int p,Set<Integer> st,List<int[]>[] matrix){
        int s=0;
        for(int[] mat:matrix[u]){
            int v=mat[0];
            int c=mat[1];
            if(v==p) continue;
            int res=dfs(v,u,st,matrix);
            if(res>0||st.contains(v)){
                s+=2*c+res;
            }
        }
        return s;
    }
}
