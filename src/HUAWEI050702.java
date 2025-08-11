import java.util.*;

public class HUAWEI050702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一棵树，在树上最少的点，可以覆盖完整棵树；
        String[] str=sc.nextLine().split(" ");
        int[] tree=new int[str.length];
        for(int i=0;i<str.length;i++){
            if(str[i]=="N"){
                tree[i]=-1;
            }else tree[i]=Integer.parseInt(str[i]);
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        TreeNode root=new TreeNode(tree[0]);
        int n=str.length;
        int i=1;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(i++<n&&tree[i]!=-1){
                node.left=new TreeNode(tree[i]);
                q.offer(node.left);
            }
            if(i++<n&&tree[i]!=-1){
                node.right=new TreeNode(tree[i]);
                q.offer(node.right);
            }
        }
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

    //一棵树，在树上找到最小的点，使得它可以覆盖整棵树。输出最少需要的点数量
    //一个点可以包括它自己和父、子节点；
    //状态定义：一定是以当前点作为一个对象。dp[i][0]表示自己是基站，dp[i][1]表示自己被子节点覆盖，dp[i][2]表示自己被父节点覆盖
    //状态转移：当前状态由前面状态如何转移得到；
    //当前状态是:先列所有可能的状态再剪枝
    //基站：dp[i][0]=min(dp[i.left][0],dp[i.left][1],dp[i.left][2])+min(dp[i.right][0],dp[i.right][1],dp[i.right][2])+1
    //被子节点覆盖：dp[i][1]=

}
