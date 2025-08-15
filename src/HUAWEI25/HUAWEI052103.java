package HUAWEI25;

import java.util.*;
public class HUAWEI052103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //M数量GPU核数
        int M=sc.nextInt();
        //客户数量
        int N=sc.nextInt();
        //一个时间单位下一个GPU核的费用
        int R=sc.nextInt();
        sc.nextLine();
        List<List<segement>> clients=new ArrayList<>();
        for(int i=1;i<=N;i++){
            String[] str=sc.nextLine().split(" ");
            int k=Integer.parseInt(str[0]);
            List<segement> client=new ArrayList<>();
            for(int j=1;j<=k;j++){
                String[] s=str[j].split(":");
                int start=Integer.parseInt(s[0]);
                int end=Integer.parseInt(s[1]);
                int needCores=Integer.parseInt(s[2]);
                client.add(new segement(start,end,needCores));
            }
            clients.add(client);
        }

        //二进制枚举,共2^n种选法
        int state=1<<N;
        long ans=0;
        for(int i=0;i<state;i++){
            List<segement> segs=new ArrayList<>();
            long sumCores=0;
            for(int j=0;j<N;j++){
                if((i&(1<<j))==0) continue;
                //第j个客户的所有区间都加入segs中
                for(segement s:clients.get(j)){
                    segs.add(s);
                    sumCores+=(long)(s.end-s.start+1)*s.needCores;
                }
            }

            //验证能否达到峰值
            if(!check(segs,M)) continue;
            ans=Math.max(ans,sumCores*R);
        }
        System.out.println(ans);
    }

    static class segement{
        int start;
        int end;
        int needCores;
        public segement(int start,int end,int needCores){
            this.start=start;
            this.end=end;
            this.needCores=needCores;
        }
    }

    //当前方案的客户区间、最大覆盖上限
    //检查当前所选的区间在任意时刻，所需要的核心量是否都能被M覆盖
    static boolean check(List<segement> segs,int M){
        //key：时间点；val：该点的权重
        Map<Integer,Integer> m=new HashMap<>();
        for(segement s:segs){
            m.put(s.start,m.getOrDefault(s.start,0)+s.needCores);
            m.put(s.end+1,m.getOrDefault(s.end+1,0)-s.needCores);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(m.entrySet());
        list.sort((a,b)->a.getKey()-b.getKey());

        //当前时刻的核心数
        int cur=0;
        for(Map.Entry<Integer,Integer> s:list){
            cur+=s.getValue();
            if(cur>M) return false;
        }
        return true;

    }
}
