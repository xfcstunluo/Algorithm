package writtenExam;

public class Test {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum=trap(height);
        System.out.println(sum);
    }

    public static int trap(int[] height) {
        //该点前缀、该点后缀和
        int n = height.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],height[i-1]);
        }
        suffix[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],height[i+1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.max(Math.min(suffix[i],prefix[i])-height[i],0);
        }
        return res;
    }
}