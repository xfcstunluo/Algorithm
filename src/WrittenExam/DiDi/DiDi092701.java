package WrittenExam.DiDi;

import java.util.*;

public class DiDi092701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //[a,b]表示应当考虑的进制区间
        int a = sc.nextInt();
        int b = sc.nextInt();
        //[l,r]询问的数字区间
        long l = sc.nextInt();
        long r = sc.nextInt();
        //波浪数的重数
        int k = sc.nextInt();
        List<Long> ans=solve(a,b,l,r,k);
        for (long x : ans) System.out.println(x);
    }

    public static List<Long> solve(int a,int b,long l,long r,int k){
        Map<Long,Integer> cnt=new HashMap<>();
        for(int p=a;p<=b;p++){
            Set<Long> s = generateInBase(p, l, r);
            for (long x : s) {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
        }
        List<Long> ans = new ArrayList<>();
        for (Map.Entry<Long, Integer> e : cnt.entrySet()) {
            if (e.getValue() == k) ans.add(e.getKey());
        }
        Collections.sort(ans);
        return ans;
    }

    //进制p，所有十进制落在[L,R]的波浪数
    public static Set<Long> generateInBase(int p,long L,long R){
        Set<Long> res=new HashSet<>();
        //单个十进制数字1~p-1
        for(int A=1;A<p&&A<=R;A++){
            if(A>=L) res.add((long)A);
        }
        //长度为2
        int n=2;
        while(true){
            long[] s = sums(p, n);
            long sEven = s[0], sOdd = s[1];
            // A>=1，A*s_even 已超上界
            if (sEven > R) break;
            for (int A = 1; A < p; A++) {
                long baseA = A * sEven;
                if (baseA > R) continue;
                for (int B = 0; B < p; B++) {
                    if (B == A) continue;
                    long x = baseA + B * sOdd;
                    if (L <= x && x <= R) res.add(x);
                }
            }
            n++;
        }
        return res;
    }

    //返回长度为n时，A位和B位权值和
    public static long[] sums(int p,int n){
        long mother=(long)(p*p-1);
        long sEven,sOdd;
        if(n%2==0){
            int m=n/2;
            //等比数列
            long pow2m=pow(p,2*m);
            sOdd=(pow2m-1)/mother;
            sEven=p*sOdd;
        }else{
            int m=(n-1)/2;
            sEven=(pow(p,2*(m+1))-1)/mother;
            if(m==0) sOdd=0;
            else sOdd = p * (pow(p, 2 * m) - 1)/mother;
        }
        return new long[]{sEven,sOdd};
    }

    static long pow(long num,int e){
        long ans=1;
        for(int i=1;i<=e;i++) ans*=num;
        return ans;
    }
}
