import java.util.*;
import java.util.stream.Collectors;

public class listMethod {
    public static final int MOD=1000000007;
    public static long sum=0;
    public static int n;
    public static int m;
    public static int k;
    //    public static List<Integer> path=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //序列长度
        n = sc.nextInt();
        //序列中每个数字范围[1,m]
        m = sc.nextInt();
        //数字之间相差的阈值
        k = sc.nextInt();
        //除第一个数字外，与前一个数字相差不超过k/前一个数字整数倍
        dfs(0,0);
        sum=sum%MOD;
        //输出：序列有几种构成方案
        System.out.println(sum);

    }
    public static void dfs(int i,int lastJ){
        if(i==n){
            sum++;
            return;
        }
        for(int j=1;j<=m;j++){
            if(i!=0){
                if(Math.abs(lastJ-j)<=k||j%lastJ==0){
                    dfs(i+1,j);
                }
            }else{
                dfs(i+1,j);
            }
        }
    }

}
