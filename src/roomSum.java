import java.util.*;
public class roomSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数组长度；
        int n = sc.nextInt();
        //数组a
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        //数组b
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<b[i];j++){
                res.add(a[i]);
            }
        }
        //询问次数
        int q=sc.nextInt();
        //下标范围
        List<int[]> list=new ArrayList<>();
        int sumX=-1,sumY=-1,lastSum=-1;
        for(int i=0;i<q;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();

            int sum=0;
            for(int j=x-1;j<=y-1;j++){
                sum+=res.get(j);
            }
            lastSum=sum;
            System.out.println(sum);
        }


    }
}
