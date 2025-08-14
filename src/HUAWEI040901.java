import java.util.*;
import java.util.stream.Collectors;
public class HUAWEI040901 {
    static Map<String,List<String>> tree=new HashMap<>();
    static int maxLength=Integer.MIN_VALUE;
    static Set<String> res=new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //版本迭代关系个数
        int n = sc.nextInt();
        sc.nextLine();
        //森林。存树的根节点
        Set<String> set=new HashSet<>();
        for(int i = 1; i <= n; i++){
            String[] str = sc.nextLine().split(" ");
            String cur=str[0];
            String pre=str[1];
            if(pre.equals("NA")) set.add(cur);
            else{
                tree.computeIfAbsent(pre,k->new ArrayList<>()).add(cur);
            }
        }
        for(String root:set){
            dfs(root,0);
        }
        List<String> ans=new ArrayList<>(res);
        Collections.sort(ans);
        //输出：所有迭代次数最多的补丁版本号字符串列表，多个版本号按字典序升序排列
        System.out.println(ans.stream()
                .collect(Collectors.joining(" ")));
    }

    public static void dfs(String u,int dep){
        if(dep>maxLength){
            maxLength=dep;
            res.clear();
            res.add(u);
        }
        if(dep==maxLength) res.add(u);
        for(String v:tree.getOrDefault(u,Collections.emptyList())) dfs(v,dep+1);
    }
}
