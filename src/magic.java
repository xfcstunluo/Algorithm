import java.util.*;
public class magic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n门课程，m层楼，M点初始法力
        int n = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int[] power=new int[n];
        //学这门课能提升的魔法强度
        for(int i=0;i<n;i++){
            power[i]=sc.nextInt();
        }
        //学这门课需要消耗的法力值
        int[] mana=new int[n];
        for(int i=0;i<n;i++){
            mana[i]=sc.nextInt();
        }
        //每层的环境加成系数bonus[]
        int[] bonus=new int[m];
        for(int i=0;i<m;i++){
            bonus[i]=sc.nextInt();
        }
        //必须按顺序学习课程；每门课只能在某一层完成学习；第j层学习第i门：power[i]*bonus[j];
        //首次选择楼层没有代价，从低到高切换，消耗法力高-低；从高到低切换不消耗
        //状态定义：dp[i]表示学习第i门课程，最大魔法强度总和；
        //状态转移：dp[i]=dp[i-1]+bonus[for j]*power[i] && <=M
        //初始化数组：dp[0]=0;
        int[] dp=new int[n+1];
        int curJ=-1;
        boolean flag=true;
        for(int i=0;i<n;i++){
            int tmp=0;
            int tmpJ=-1;
            int tmpM=-1;
            for(int j=0;j<m;j++){
                if(curJ==-1){
                    tmpM=M-mana[j];
                    if(tmpM>0){
                        tmp=Math.max(tmp,bonus[j]*power[i]);
                        tmpJ=j;
                    }else {
                        flag=false;
                        break;
                    }
                }else{
                    if(curJ>=j){
                        tmpM=M-mana[j];
                        if(tmpM>0){
                            tmp=Math.max(tmp,bonus[j]*power[i]);
                            tmpJ=j;
                        }else {
                            flag=false;
                            break;
                        }
                    }else{
                        tmpM=M-mana[j]-(j-curJ);
                        if(tmpM>0){
                            tmp=Math.max(tmp,bonus[j]*power[i]);
                            tmpJ=j;
                        }else {
                            flag=false;
                            break;
                        }
                    }

                }
            }
            if(flag==false) break;
            else{
                dp[i+1] = dp[i] + tmp;
                curJ=tmpJ;
                M-=mana[curJ];
            }

        }
        int maxMagic=0;
        for(int d:dp){
            maxMagic=Math.max(maxMagic,d);
        }
        System.out.println(maxMagic);

        //输出：不超过M的情况下，能获得的最大魔法强度总和（无需学完所有课程）
    }
}
