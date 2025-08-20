package HUAWEI24;
import java.util.*;
import java.util.stream.Collectors;
public class HUAWEI103001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //套餐数量
        int m = sc.nextInt();
        PriorityQueue<food> heap = new PriorityQueue<>((a,b)->{
            if(a.cost!=b.cost) return Integer.compare(a.cost,b.cost);
            else if(a.earn!=b.earn) return Integer.compare(b.earn,a.earn);
            else return Integer.compare(a.index,b.index);
        });
        for(int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int cost = sc.nextInt();
            int earn = sc.nextInt();
            food f=new food(i,id,cost,earn);
            heap.offer(f);
        }
        //限制数量
        int n=sc.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i = 0; i<n; i++) {
            int id=sc.nextInt();
            int limit=sc.nextInt();
            map.put(id,limit);
        }
        //推出套餐的数量
        int num=sc.nextInt();
        //优先级：成本低，利润高，套餐索引小；
        List<Integer> list=new ArrayList<>();
        while(!heap.isEmpty()&&list.size()<num) {
            food f=heap.poll();
            if(map.containsKey(f.id)&&map.get(f.id)>0) {
                map.put(f.id,map.get(f.id)-1);
                list.add(f.index);
            }else if(!map.containsKey(f.id)) list.add(f.index);
        }
        //输出：购买套餐的索引，升序排列，数量不足返回-1
        if(list.size()<num) System.out.println(-1);
        else{
            Collections.sort(list);
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

    }

    static class food{
        int index;
        int id;
        int cost;
        int earn;
        int limit;
        food(int index,int id, int cost, int earn) {
            this.index = index;
            this.id = id;
            this.cost = cost;
            this.earn = earn;
        }
    }
}
