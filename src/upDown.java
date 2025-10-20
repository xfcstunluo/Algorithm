import java.util.*;
public class upDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int MOD=1000000007;
        while (T-- > 0) {
            int n = sc.nextInt();
            //翻转次数上限
            int m = sc.nextInt();
            //好对数量目标
            int good=sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            int ans=0;
            for(int i=0;i<n/2;i++){
                if(str.charAt(i)==str.charAt(n-i-1)) ans++;
            }
            if(ans==good) System.out.println(1);
            else{

            }
        }
    }
}
