import java.util.*;
public class TaoTian051701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            long[] nums=new long[26];
            int sum=0;
            for(int i=0;i<26;i++){
                nums[i]=sc.nextLong();
                if(nums[i]!=0){
                    sum++;
                }
            }
            long[] arr=new long[sum];
            int k=0;
            for(int i=0;i<26;i++){
                if(nums[i]!=0){
                    arr[k++]=nums[i]-1;
                }
            }
            Arrays.sort(arr);
            long sumRes=sum;
            for(int i=0;i<sum;i++){
                long tmp=sumRes-1;
                if(arr[i]<=tmp) sumRes+=arr[i];
                else sumRes+=tmp;
            }
            System.out.println(sumRes);
        }
    }
}
