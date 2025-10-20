import java.util.*;
public class conflict {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            //数组长度
            int n = sc.nextInt();
            //观点相近的阈值
            int d = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            //一次操作选择一对，若|ai-aj|<=d，两者观点相近，两者同时删除
            //状态定义：dp[k]表示删除k次后，数组最终剩下多少
            //状态转移：dp[k]=max(dp[k],if(满足则删除) dp[k-1]+1);

            //输出：不包含任何观点相近的元素，保留数量最多的元素
        }
    }
}
