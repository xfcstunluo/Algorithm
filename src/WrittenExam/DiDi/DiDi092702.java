package WrittenExam.DiDi;//贪心、二分答案判定
import java.util.*;
public class DiDi092702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            //n间房屋
            int n = sc.nextInt();
            //记录该房屋有多少个儿子
            int[] childCount=new int[n+1];
            for(int i=2;i<=n;i++){
                int p=sc.nextInt();
                childCount[p]++;
            }
            //除编号为1的房屋为根，其它房间都有一个通过向上连接的房屋i
            //若某些房屋有相同的父房屋，则他们可以互相通信
            //每个时刻，1.儿子房间中至少有一个房间知道了消息，则可以让恰好一个未知情的儿子房间知晓；2.小红可以任意选择一个未知情的房间告知消息

            //总共T个时刻内，如何分配点名次数，让尽可能多的人知道消息
            //提取有孩子的房屋
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=1;i<=n;i++){
                if(childCount[i]!=0) list.add(childCount[i]);
            }
            //降序排序，优先启动大的孩子集合
            list.sort(Collections.reverseOrder());

            int m=list.size();
            int[] cnt=new int[m+1];
            for(int i=1;i<=m;i++){
                cnt[i]=list.get(i-1);
            }

            //二分，在[0，n]中找第一个>=n的集合
            int left=0,right=n;
            while(left<=right){
                int mid=(left+right)/2;
                if(check(mid,n,cnt,m)) right=mid-1;
                else left=mid+1;
            }
            //输出：最佳选择下，第几个时刻可以让所有房间得知消息
            System.out.println(left);
        }

    }

    //若总共只有T个时刻，能否在最优选择下让n个房间都得知消息
    public static boolean check(int T,int n,int[] cnt,int m){
        //根节点需要小红花费1个时刻点一次，不存在0时刻能完成的情况
        if(T==0) return false;

        //排除点根后剩下可用的点名次数
        int available=T-1;
        //点名次数与实际有非空子集被点父房间，判断最多取多少次点名次数
        int g=Math.min(available,m);
        int base=0;
        for(int i=1;i<=g;i++){
            //cnt倒序，第i个集合在第i个时刻被启动，让大的集合尽可能多的时刻被扩散。
            //本身需要扩散多少次以让所有孩子收到信息 与 能扩多少次 取交集
            base+=Math.min(cnt[i],T-i+1);
        }

        //若点名次数在点完所有非空子集后还有剩，小红可用去帮忙点子集
        int extra=Math.max(0,available-m);
        int knownChildren=Math.min(n-1,base+extra);
        //总点加上点根的一次
        int totalKnown =knownChildren+1;
        return totalKnown >=n;
    }
}
