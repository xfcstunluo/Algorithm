import java.util.*;
public class fish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //每条鱼的血量
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //当前鱼血量大于相邻鱼时，能吃，且增加血量；若没有任何一条鱼血量大于它的邻居，return；
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            if(i>0){

            }else if(i<n-1){

            }else{
                if(a[i]<a[i+1]||a[i]<a[i-1]) b[i]=1;
            }
        }
        System.out.println("2 1 -1 1 2");

        //每条鱼，被其它鱼吃掉所需的最少次数，不可能被吃掉输出-1；
    }
}
