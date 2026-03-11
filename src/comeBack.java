import java.util.*;
public class comeBack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            list.add(new int[]{sc.nextInt(),sc.nextInt()});
        }
        int[][] dependencyChain=list.toArray(new int[list.size()][]);
        ArrayList<ArrayList<Integer>> result=getAncestors(m, dependencyChain);
    }
    public static ArrayList<ArrayList<Integer>> getAncestors (int m, int[][] dependencyChain){
        //节点整数m
        //dependencyChain[i][j]表示任务i必须在任务j开始前完成，即存在一条从i指向j的依赖边
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int[] dependency : dependencyChain){
            int target = dependency[0];
            int source = dependency[1];
            if(!map.containsKey(source)) {
                map.put(source, new ArrayList<>());
                map.get(source).add(target);
            }else map.get(source).add(target);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> list = entry.getValue();
            Collections.sort(list);
            result.get(entry.getKey()).addAll(list);
        }
        //输出：result，result[k]表示所有必须在任务k之前完成的任务，升序排列
        return result;
    }
}

//8
//0 3 0 4 1 3 2 4 2 7 3 5 3 6 3 7 4 6