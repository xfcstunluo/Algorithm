import java.util.*;
import java.util.stream.Collectors;

public class sortList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //构造长度为n的排列，任意位置i，与ai亦或为奇数
        //排列：由1~n每个数按任意位置组成
        int T=sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            //只要n为偶数，亦或的结果一定有奇数，反之一定是偶数，偶数只要输出排列两两交换
            if(n%2==1) System.out.println("-1");
            else{
                int[] nums = new int[n];
                int k=1;
                for(int i=0;i<n;i++){
                    nums[i]=k++;
                }
                for(int i=0;i<n;i+=2){
                    int tmp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=tmp;
                }
                List<Integer> list = new ArrayList<>();
                for(int i=0;i<n;i++){
                    list.add(nums[i]);
                }
                System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
        //输出：存在则输出任意一个满足条件的排列，不满足输出-1；
    }
}
