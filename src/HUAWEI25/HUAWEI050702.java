package HUAWEI25;

import java.util.*;

public class HUAWEI050702 {
    static int INF=1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一棵树，在树上最少的点，可以覆盖完整棵树；
        String[] str=sc.nextLine().split(" ");
        int[] tree=new int[str.length];
        for(int i=0;i<str.length;i++){
            if(str[i].equals("N")){
                tree[i]=-1;
            }else tree[i]=Integer.parseInt(str[i]);
        }
        //建树
        TreeNode root=buildTree(tree);
        int[] result=dfs(root);
        System.out.println(Math.min(result[0],result[1]));

        //一棵树，在树上找到最小的点，使得它可以覆盖整棵树。输出最少需要的点数量
        //一个点可以包括它自己和父、子节点；
        //状态定义：一定是以当前点作为一个对象。dp[i][0]表示自己是基站，dp[i][1]表示自己被子节点覆盖，dp[i][2]表示自己被父节点覆盖
        //状态转移：当前状态由前面状态如何转移得到；
        //当前状态是:先列所有可能的状态再剪枝
        //基站：dp[i][0]=min(dp[i.left][0],dp[i.left][1],dp[i.left][2])+min(dp[i.right][0],dp[i.right][1],dp[i.right][2])+1
        //被子节点覆盖：不取相加，分两种情况：被左儿子覆盖和被右儿子覆盖；
        // dp[i][1]=min(dp[i.left][0]+min(dp[i.right][0],dp[i.right][1]),右边情况同)
        //被父节点覆盖，左右孩子可选，相加
        //dp[i][2]=min(dp[i.left][0],dp[i.left][1])+右节点
    }

    public static int[] dfs(TreeNode node){
        if(node==null) return new int[]{INF,0,0};
        //三个值表示开销。当节点是叶子结点时，若它自己是基站，dp[0]=1;若它是被子节点或者父节点覆盖的，ga该点的开销应该是0.
        if(node.left==null&&node.right==null) return new int[]{1,INF,0};
        //讨论三种情况
        int[] L=dfs(node.left);
        int[] R=dfs(node.right);
        int dp0=Math.min(L[0],Math.min(L[1],L[2]))+Math.min(R[0],Math.min(R[1],R[2]))+1;
        int dp1=Math.min(L[0]+Math.min(R[0],R[1]),R[0]+Math.min(L[0],L[1]));
        int dp2=Math.min(L[0],L[1])+Math.min(R[0],R[1]);
        return new int[]{dp0,dp1,dp2};
    }

    public static TreeNode buildTree(int[] tree){
        TreeNode root=new TreeNode(tree[0]);
        Deque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        int n=tree.length;
        int i=1;
        while(!q.isEmpty()&&i<n){
            TreeNode node=q.poll();
            if(i<n&&tree[i]!=-1){
                TreeNode left=new TreeNode(tree[i]);
                node.left=left;
                q.offer(left);
            }
            i++;
            if(i<n&&tree[i]!=-1){
                TreeNode right=new TreeNode(tree[i]);
                node.right=right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        TreeNode(int val){
            this.val = val;
        }
    }


}
