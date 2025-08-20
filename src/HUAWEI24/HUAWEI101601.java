package HUAWEI24;
import java.util.*;
public class HUAWEI101601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int[] tree = new int[n];
        for(int i=1;i<str.length;i++){
            tree[i-1]=Integer.parseInt(str[i]);
        }
        //平衡树叶子节点值的查询范围
        //个数，最小值，最大值
        int num=sc.nextInt(),minVal=sc.nextInt(),maxVal=sc.nextInt();
    }
}
