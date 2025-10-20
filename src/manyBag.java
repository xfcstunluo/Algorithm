import java.util.*;
public class manyBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //业务员
        int[] a = new int[n];
        //任务
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int aSum=0,bSum = 0;
        for(int i = 0 ; i < n ; i++){
            aSum+=a[i];
        }
        for(int i=0;i<m;i++) {
            bSum +=b[i];
        }
        if(aSum<bSum){
            System.out.println("NO");
            return;
        }
        for(int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--) {
                if(a[i]>=b[j]&&b[j]!=0){
                    a[i]-=b[j];
                    bSum-=b[j];
                    b[j]=0;
                    if(bSum==0) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
        //输出：可以全部分配输出yes，否则no
    }
}
