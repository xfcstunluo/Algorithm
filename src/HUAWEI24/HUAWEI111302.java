package HUAWEI24;
import java.util.*;
public class HUAWEI111302 {
    static Set<Integer> setCol=new HashSet<>();
    //主对角线相同的只能有一个
    static Set<Integer> mainLine=new HashSet<>();
    //副对角线相同的只能有一个
    static Set<Integer> secLine=new HashSet<>();
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        n =sc.nextInt();
        int ans=dfs(0);
        System.out.println(ans);
    }
    static int dfs(int row){
        //已经递归到第n+1行，说明前面已经成功放置；
        if(row==m) return 1;
        //统计方案数
        int ans=0;
        for(int col = 0; col< n; col++){
            int main=row+col;
            int sec=row-col;
            if(setCol.contains(col)||mainLine.contains(main)||secLine.contains(sec)) continue;
            setCol.add(col);
            mainLine.add(main);
            secLine.add(sec);
            ans+=dfs(row+1);
            setCol.remove(col);
            mainLine.remove(main);
            secLine.remove(sec);
        }
        return ans;
    }
}
