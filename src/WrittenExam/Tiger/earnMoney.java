package WrittenExam.Tiger;
import java.util.*;
public class earnMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s=str.substring(1,str.length()-3).split(",");
        char numStr=str.charAt(str.length()-1);
        int maxRisePct=numStr-'0';
        int n=s.length;
        int[] prices=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=Integer.parseInt(s[i]);
        }
        //不必连续的子序列，但保证价格严格递增、子序列中任意相邻的两个元素，后者的价格相对于前者的价格涨幅百分比不超过maxRisePct
        int ans=0;
        List<Integer> res=new ArrayList<>();
        for(int r=0;r<n;r++){
            if(!res.isEmpty()){
                int p=res.get(res.size()-1);
                if(prices[r]<p) continue;
                double k=(prices[r]-p)/p;
                if(k<maxRisePct){
                    res.add(prices[r]);
                }
            }else res.add(prices[r]);
        }
        ans=Math.max(ans,res.size());

        //输出：最长稳定增长趋势长度
        System.out.println(ans);
    }
}
