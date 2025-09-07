package writtenExam;

import java.util.*;
public class MeiTuan051001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int[] nums=new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
                sum+=nums[i];
            }
            int[] arr=new int[4];
            for(int i=0;i<4;i++){
                arr[i]=sc.nextInt();
            }
            int D=Math.abs(arr[2]-arr[0])+Math.abs(arr[3]-arr[1]);
            if(sum>=D){
                if(sum==D) System.out.println("YES");
                else if((sum-D)%2==0) System.out.println("YES");
                else System.out.println("NO");
            }else{
                System.out.println("NO");
            }

        }
    }
}
