package Exam.DEWU;

import java.util.*;

public class DEWU090603 {
    static class Line {
        final int A, B, C;
        Line(int A, int B, int C) { this.A=A; this.B=B; this.C=C; }
        @Override public boolean equals(Object o){
            if(this==o) return true;
            if(o==null || getClass()!=o.getClass()) return false;
            Line other=(Line)o;
            return A==other.A && B==other.B && C==other.C;
        }
        @Override public int hashCode(){ return Objects.hash(A,B,C); }
    }

    static int gcd(int a, int b){
        a = Math.abs(a); b = Math.abs(b);
        while(b != 0){ int t = a % b; a = b; b = t; }
        return a;
    }
    static Line fromPoints(int x1,int y1,int x2,int y2){
        int A = y2 - y1;
        int B = x1 - x2;
        int C = x2*y1 - x1*y2;
        int g = gcd(gcd(A,B), C);
        if (g != 0){ A/=g; B/=g; C/=g; }
        // 统一符号，确保同一直线键完全一致
        if (A < 0 || (A==0 && B < 0) || (A==0 && B==0 && C < 0)){
            A = -A; B = -B; C = -C;
        }
        return new Line(A,B,C);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] xs = new int[n], ys = new int[n];
        for(int i=0;i<n;i++){ xs[i]=sc.nextInt(); ys[i]=sc.nextInt(); }

        Map<Line, BitSet> map = new HashMap<>();
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (xs[i]==xs[j] && ys[i]==ys[j]) continue; //同点对，跳过
                Line key = fromPoints(xs[i], ys[i], xs[j], ys[j]);
                BitSet bs = map.get(key);
                if (bs == null){ bs = new BitSet(n); map.put(key, bs); }
                bs.set(i); bs.set(j);
            }
        }

        int ans = 0;
        for (BitSet bs : map.values()){
            if (bs.cardinality() >= k) ans++;
        }
        System.out.println(ans);
    }
}
