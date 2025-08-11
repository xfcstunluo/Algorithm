import java.util.*;
public class HUAWEI051403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] carsString=sc.nextLine().split(" ");
        int n=carsString.length;
        //各市物资车数
        int[] cars=new int[n];
        for(int i=0;i<n;i++){
            cars[i]=Integer.parseInt(carsString[i]);
        }
        String[] requiresString=sc.nextLine().split(" ");
        //领物资需求车数
        List<Integer> requires=new ArrayList<>();
        for(int i=0;i<requiresString.length;i++){
            requires.add(Integer.parseInt(requiresString[i]));
        }
        //找到需求和<=该物资车数 的最长的一个子队伍->子序列和小于等于K的最长连续子序列
        //如果没有找到任何满足条件的子序列，放下一个车队进来与该车队累加，在进行上述步骤。
        //当前和，找最长子序列，滑动窗口？
        int ans=0;

        int cur=0;
        for(int i=0;i<cars.length;i++){
            int left=0;
            cur+=cars[i];
            int bestLeft=-1,bestRight=-1;
            int maxLen=0;
            int curSum=0;
            for(int right=0;right<requires.size();right++){
                curSum+=requires.get(right);
                while(curSum>cur){
                    curSum-=requires.get(left);
                    left++;
                }
                int len=right-left+1;
                if(len>maxLen){
                    maxLen=len;
                    bestLeft=left;
                    bestRight=right;
                }
            }
            if(bestLeft!=-1){
                ans++;
                cur=0;
                for(int j=bestLeft;j<=bestRight;j++){
                    requires.remove(bestLeft);
                }
            }
        }
        //输出分配总次数，不能分到物资的人数
        if(requires.size()==0){
            System.out.println(ans+" "+0);
        }else{
            System.out.println(ans+" "+requires.size());
        }

    }
}
