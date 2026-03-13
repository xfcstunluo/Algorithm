package WrittenExam.PDD;//顺序DP
import java.util.*;
public class PDD092803 {
    static final int NEG=-1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n门课程，m层楼，M点初始法力
        int n = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int[] power=new int[n+1];
        //power[i]学这门课能提升的魔法强度
        for(int i=1;i<=n;i++){
            power[i]=sc.nextInt();
        }
        //mana[i]学这门课需要消耗的法力值
        int[] mana=new int[n+1];
        for(int i=1;i<=n;i++){
            mana[i]=sc.nextInt();
        }
        //bonus[i]每层的环境加成系数
        int[] bonus=new int[m+1];
        for(int i=1;i<=m;i++){
            bonus[i]=sc.nextInt();
        }

        //必须按顺序学习课程；每门课只能在某一层完成学习；第j层学习第i门：提升强度power[i]*bonus[j]，消耗法力mana[i] × bonus[j];
        //首次选择楼层没有代价，从低到高切换，消耗法力值高-低；从高到低切换不消耗
        //状态定义：dp[p][c]课学在第p层，总法力消耗为c，获得最大总强度
        //状态转移：第i门课学在第j层，消耗为课程消耗+切楼消耗，mana[i]*bonus[j]+max(0,j-p)
        //          if(c+mana[i]*bonus[j]+max(0,j-p)<=M) 就允许转移
        //          dp[j][c+mana[i]*bonus[j]+max(0,j-p)]=dp[p][c]+power[i]*bonus[j]?
        //          cur[j][newCost] = max(cur[j][newCost], prev[p][c] + gain)
        //初始化数组：prev[0][0]=cur[0][0]=0;

        //prev[j][c]：处理完上一门课后，最后在第j层，总花费c时的最大强度
        int[][] prev=new int[m+1][M+1];
        int[][] cur=new int[m+1][M+1];

        for(int i=1;i<=m;i++){
            Arrays.fill(prev[i],NEG);
            Arrays.fill(cur[i],NEG);
        }
        int ans=0;

        //初始化第一门课
        for(int j=1;j<=m;j++){
            int cost=mana[1]*bonus[j];
            int gain=power[1]*bonus[j];
            if(cost<=M){
                prev[j][cost]=gain;
                ans=Math.max(ans,gain);
            }
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                Arrays.fill(cur[j],NEG);
            }
            //枚举上一门课结束时在哪一层
            for(int p=1;p<=m;p++){
                for(int c=0;c<=M;c++){
                    if(prev[p][c]==NEG) continue;
                    //如果第i-1门课能够学完
                    //枚举第i门课在第j层学习
                    for(int j=1;j<=m;j++){
                        int moveCost=Math.max(0,j-p);
                        int learnCost=mana[i]*bonus[j];
                        //所消耗的法力
                        int extra=moveCost+learnCost;
                        if(c+extra<=M){
                            int gain=power[i]*bonus[j];
                            cur[j][c+extra]=Math.max(cur[j][c+extra],prev[p][c]+gain);
                            ans=Math.max(ans,cur[j][c+extra]);
                        }
                    }
                }
            }

            //当前结果作为下一轮的上层状态
            int[][] temp=prev;
            prev=cur;
            cur=temp;
        }
        //输出：不超过M的情况下，能获得的最大魔法强度总和（无需学完所有课程）
        System.out.println(ans);
    }
}
