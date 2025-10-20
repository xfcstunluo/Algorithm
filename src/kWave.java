import java.util.*;
public class kWave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //[a,b]表示应当考虑的进制区间
        int a = sc.nextInt();
        int b = sc.nextInt();
        //[l,r]询问的数字区间
        int l = sc.nextInt();
        int r = sc.nextInt();
        //波浪数的重数
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=l; i<=r; i++){
            //数字i（10）转化成j进制，查看是否是波浪数
            int sum=0;
            for(int j=a; j<=b; j++){
                List<Integer> res=exchange(i,j);
                //判断是否是波浪数
                boolean flag=true;
                for(int m=0; m<res.size(); m+=4){
                    if(m+2<res.size()&&res.get(m)!=res.get(m+2)){
                        flag=false;
                        break;
                    }
                    if(m+1<res.size()&&m+3<res.size()&&res.get(m+1)!=res.get(m+3)){
                        flag=false;
                        break;
                    }
                }
                if(flag==true) sum++;
                if(sum+b-j<k) break;
            }
            if(sum==k) list.add(i);
        }

        //输出：十进制输出波浪数
        for(int num:list){
            System.out.println(num);
        }
    }
    public static List<Integer> exchange(int i, int j){
        List<Integer> res = new ArrayList<>();
        int tmp=1;
        for(;tmp<=1000;tmp++){
            if(Math.pow(j,tmp)>i) break;
        }
        int curJ=tmp-1;
        while(i!=0){
            int cur=i/(int)(Math.pow(j,curJ));
            res.add(cur);
            i%=(int)(Math.pow(j,curJ));
            curJ--;
        }
        for(int m=0;m<=curJ;m++){
            res.add(0);
        }
        return res;
    }
}
