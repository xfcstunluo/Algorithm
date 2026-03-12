package WrittenExam.RedNote;//冲突约束
//贪心
//尽可能大地合法保留集合，先排序，再能选则选。因为排序后越小的数越早出现，不选这个数，会导致后面的数更难选
import java.util.*;
public class RedNote25092101 {
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
            Arrays.sort(nums);
            int last= Integer.MIN_VALUE;
            int ans=0;
            for(int x: nums){
                if(x-last>d){
                    ans++;
                    last=x;
                }
            }
            if((n-ans)%2==1) ans-=1;
            //输出：不包含任何观点相近的元素，保留数量最多的元素
            System.out.println(ans);
        }
    }
}
