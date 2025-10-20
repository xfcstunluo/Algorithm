import java.util.*;
import java.util.stream.Collectors;

public class testListMethod {
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
        System.out.println(sum);

    }
    public static void dfs(int i,int lastJ){
        if(i==n){
            sum++;
            return;
        }
        if(i!=0){
            for(int j=0;j<=k;j++){
                dfs(i+1,lastJ+j);
            }
            int startJ=(lastJ+k)/lastJ+1;
            for(int j=lastJ*startJ;j<=m;j+=lastJ){
                dfs(i+1,j);

            }
        }else{
            for(int j=1;j<=m;j++){
                dfs(i+1,j);
            }
        }
    }




//    public static void dfs(int i,int lastJ){
//        if(i==n){
//            sum++;
//            return;
//        }
//        for(int j=1;j<=m;j++){
//            if(i!=0){
//                if(Math.abs(j-lastJ)<=k||j%lastJ==0){
//                    dfs(i+1,j);
//                }
//            }else{
//                dfs(i+1,j);
//            }
//        }
//    }

}
