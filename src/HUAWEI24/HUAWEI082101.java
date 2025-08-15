package HUAWEI24;
import java.util.*;
import java.util.stream.Collectors;

public class HUAWEI082101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数据的个数
        int n = sc.nextInt();
        int tmpN=n;
        //数据库大小
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Set<List<Integer>> set = new HashSet<>();
        Map<List<Integer>, Integer> map = new LinkedHashMap<>();
        int i=0;
        while(n-k>=0){
            n-=k;
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < k; j++){
                list.add(arr[i++]);
            }
            if(!set.contains(list)){
                set.add(list);
                map.put(list, 1);
            }else map.put(list, map.get(list)+1);
        }
        if(n!=0){
            List<Integer> list = new ArrayList<>();
            for(;i<tmpN;i++){
                list.add(arr[i]);
            }
            map.put(list,1);
        }
        //判断当前数据块是否和前面的数据块有重复，重复则删除该数据块，并在第一个出现数据库后面+1；
        //set？
        //输出：map的key和value
        List<Integer> listAll = new ArrayList<>();
        for(Map.Entry<List<Integer>,Integer> entry:map.entrySet()){
            List<Integer> list = entry.getKey();
            listAll.addAll(list);
            int count = entry.getValue();
            listAll.add(count);
        }
        System.out.println(listAll.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
