package writtenExam.YiDong;
import java.util.*;
public class numPartition {
    public static int ans=0;
    public static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> path = new ArrayList<>();
        dfs(n,1,path);
        for(List<Integer> list : res){
            System.out.println(list);
        }
        System.out.println(ans);
    }
    public static void dfs(int remain, int start, List<Integer> path) {
        if(remain==0){
            ans++;
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=remain;i++){
            path.add(i);
            dfs(remain-i,i,path);
            path.remove(path.size()-1);
        }
    }

}
