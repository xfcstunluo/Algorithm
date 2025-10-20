import java.util.*;
public class power {
    public static List<Integer> path=new ArrayList<>();
    public static List<List<Integer>> ans=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //节点数量
        int n = sc.nextInt();
        //临界值
        int k = sc.nextInt();
        //每个节点的能量
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans=0;
        //每个节点为正/负能量，激活序列[l,r]时，计算从起始位置到区间内每一个位置的能量总和，最大者作为峰值
        //只有某个区间的峰值正好等于临界值，才能激活核心
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long sum=0;
                int l=i;
                for(;l<=j;l++){
                    sum+=arr[l];
                    if(sum==k){
                        ans=ans+n-l;
                        break;
                    }
                }
                if(l<=j) break;
            }
        }
        //输出：所有能激活核心的区间数量
        System.out.println(ans);
    }

}

