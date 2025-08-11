import java.util.*;
import java.util.stream.Collectors;
public class HUAWEI051401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //操作总数
        int N = sc.nextInt();
        sc.nextLine();
        //key表示id，val表示优先级
        Map<Integer,Integer> m=new HashMap<>();
        Map<Integer,Integer> mTmp=new HashMap<>();
        List<List<Integer>> result=new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(!sc.hasNextLine()){
                System.out.println("null");
                return;
            }
            String[] str=sc.nextLine().split(" ");
            if(str[0].equals("+")){
                int id=Integer.parseInt(str[1]);
                int priority=Integer.parseInt(str[2]);
                m.put(id,priority);
            }else if(str[0].equals("=")){
                //每次更新经验值时，之前所有的经验都要回到经验池中；将mTmp的所有内容复制会m，再更新指定id的优先级
                int id=Integer.parseInt(str[1]);
                int priority=Integer.parseInt(str[2]);
                for(Map.Entry<Integer,Integer> entry:mTmp.entrySet()){
                    int key=entry.getKey();
                    int value=entry.getValue();
                    m.put(key,value);
                }
                m.put(id,priority);
                mTmp=new HashMap<>();
            }else{
                int k=Integer.parseInt(str[1]);
                //提取当前map中优先级最高的k个经验对应的id，输出，并将它们的存到一个临时的map里面
                //按经验的优先级降序排列，若优先级相同则按id升序排列
                //特殊情况：剩余经验个数小于k（map.size）返回-1；
                List<Map.Entry<Integer,Integer>> l=new ArrayList<>(m.entrySet());
                l.sort((a,b)->{
                    if(a.getValue()!=b.getValue()) return b.getValue()-a.getValue();
                    else return a.getKey()-b.getKey();
                });
                List<Integer> res=new ArrayList<>();
                if(m.size()<k){
                    res.add(-1);
                }else{
                    for(int j=0;j<k;j++){
                        res.add(l.get(j).getKey());
                        mTmp.put(l.get(j).getKey(),l.get(j).getValue());
                        m.remove(l.get(j).getKey());
                    }
                }
                result.add(res);
            }
        }
        //所有操作没有extract操作，返回null
        if(result.size()==0) System.out.println("null");
        //入参的操作总数与实际的操作行数不匹配，返回null
        for(List<Integer> res:result){
            System.out.println(res.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }
}
