package HUAWEI24;
import java.util.*;
public class HUAWEI102302 {
    static int[] arr;
    static int INF=1000000000;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        n=str.length;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        //输出：最少需要建设的基站数
        //状态定义：dp[0]自己是基站 dp[1]被子节点覆盖 dp[2]被父节点覆盖；
        //状态转移：当前状态由前面状态如何转移得到，当前节点如何由子节点得到
        //自己是基站：dp[u][0]=min(dp[v][0],dp[v][1],dp[v][2])+min(右)；
        //自己被子节点覆盖：dp[u][1]=min(dp[left][0]+min(dp[right][0],dp[right][1]),右同)；
        //自己被父节点覆盖：dp[u][2]=min(dp[left][0],dp[left][1])+右同；
        int[] minStation=dfs(0);
        int ans=Math.min(minStation[0],minStation[1]);
        System.out.println(ans);
    }
    static int[] dfs(int i){
        //判断是否有节点，
        if(i>=n||arr[i]==0) return new int[]{INF,0,0};
        //如果是叶节点
        int l=2*i+1,r=2*i+2;
        boolean hasL=(l<n)&&(arr[l]!=0);
        boolean hasR=(r<n)&&(arr[r]!=0);
        //只能自底向上影响
        if(!hasL&&!hasR) return new int[]{1,INF,0};
        int[] L=dfs(2*i+1);
        int[] R=dfs(2*i+2);
        int dp0=Math.min(L[0],Math.min(L[1],L[2]))+Math.min(R[0],Math.min(R[1],R[2]))+1;
        int dp1=Math.min(L[0]+Math.min(R[0],R[1]),R[0]+Math.min(L[0],L[1]));
        int dp2=Math.min(L[0],L[1])+Math.min(R[0],R[1]);
        return new int[]{dp0,dp1,dp2};
    }
}
