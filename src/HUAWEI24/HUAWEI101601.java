package HUAWEI24;
import java.util.*;
public class HUAWEI101601 {
    static int sumLeaf=0;
    static int maxLeaf=0;
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> input = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            input.add(sc.nextInt());
        }
        Collections.sort(input);
        //平衡树叶子节点值的查询范围
        //个数，最小值，最大值
        int num=sc.nextInt(),minVal=sc.nextInt(),maxVal=sc.nextInt();
        TreeNode root=buildBalanceTree(input,0,n-1);
        findLeaf(root,minVal,maxVal);
        if(count==num) System.out.println(sumLeaf);
        else if(sumLeaf==0) System.out.println(maxLeaf);
        else System.out.println(-1);

        //输出：满足查询范围的叶节点数据之和，找不到满足查询条件的叶节点，输出叶节点最大值，其它情况返回-1
    }

    public static void findLeaf(TreeNode root,int minVal,int maxVal){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(root.val>=minVal&&root.val<=maxVal){
                sumLeaf+=root.val;
                count++;
            }
            maxLeaf=Math.max(maxLeaf,root.val);
        }
        findLeaf(root.left,minVal,maxVal);
        findLeaf(root.right,minVal,maxVal);
    }

    //使用有序数组构建平衡二叉树
    public static TreeNode buildBalanceTree(List<Integer> input,int l,int r){
        if(l>r) return null;
        //取中间元素作为当前节点
        int mid=(l+r)/2;
        TreeNode root=new TreeNode(input.get(mid));
        root.left=buildBalanceTree(input,l,mid-1);
        root.right=buildBalanceTree(input,mid+1,r);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
