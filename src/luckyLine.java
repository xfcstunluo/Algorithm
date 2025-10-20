import java.util.*;
public class luckyLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            int ans=0,l=0,sum=0,half=0,halfR=0;
            for(int r=0;r<n;r++){
                sum+=str.charAt(r)-'0';
                if(halfR-l+1<=k/2) {
                    half += str.charAt(halfR) - '0';
                    halfR++;
                }
                if(r-l+1<k) continue;
                int tmp=0;
                int range=l+k/2;
//                for(int i=l;i<range;i++){
//                    tmp+=str.charAt(i)-'0';
//                    if(tmp*2>sum) break;
//                }
                if(half*2==sum) ans++;
                sum-=str.charAt(l)-'0';
                half-=str.charAt(l)-'0';
                l++;
                half+=str.charAt(halfR)-'0';
                halfR++;
            }
            System.out.println(ans);
        }
    }
}
