import java.util.*;
public class line {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //有n个关键点
        int n = sc.nextInt();
        //连线至少覆盖k个点
        int k = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new int[]{x,y});
        }
        int goodNum = 0;
        //连线覆盖了k个点，这条线就是好的
        //二进制选k个点，k个值为1，计算能否成线
        for(int i=0;i<(1<<n);i++){
            //计算有多少个1，是否等于k
            int cur=i,tmp=i,tmpk=0;
            while(tmp!=0){
                if((tmp&1)==1) {
                    tmpk++;
                }
                tmp=tmp>>1;
            }
            if(tmpk==k){
                List<int[]> path = new ArrayList<>();
                Set<Double> set = new HashSet<>();
                for(int j=0;j<n;j++){
                    if((cur&j)!=0){
                        path.add(list.get(j));
                    }
                }
                int[] ans=path.get(0);
                int x=ans[0],y=ans[1];
                Double K=Double.MAX_VALUE;
                boolean flag=true;
                for(int[] res : path){
                    int a=res[0],b=res[1];
                    if(a==x && b==y) continue;
                    if(a-x==0){
                        if(set.size()==0) set.add(K);
                        else{
                            if(set.contains(K)) continue;
                            else {
                                flag=false;
                                break;
                            }
                        }
                    }else{
                        K=(double)(b-y)/(a-x);
                        if(set.size()==0) set.add(K);
                        else{
                            if(set.contains(K)) continue;
                            else {
                                flag=false;
                                break;
                            }
                        }
                    }

                }
                if(flag) goodNum++;
            }
        }
        System.out.println(goodNum);
        //输出：多少条好线
    }
}
