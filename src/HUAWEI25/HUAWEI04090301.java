package HUAWEI25;

import java.util.*;

public class HUAWEI04090301 {
    static final long MOD=1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] edges = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                edges[i][j] = sc.nextInt();
            }
        }
        int[] res=spiral(edges);
        long ans=countBST(res);
        System.out.println(ans);
    }

    //统计序列的逆序对数
    static long countBST(int[] A){
        int m=A.length;
        BIT bit=new BIT(m);
        //逆序对个数
        long ans=0;
        //已处理元素个数
        long seen=0;
        for(int a:A){
            //前面出现的<=a的个数
            long lessA=bit.sum(a);
            long greaterA=seen-lessA;
            ans+=greaterA;
            bit.add(a,1);
            seen++;
        }
        return ans%MOD;
    }

    //树状数组
    static class BIT{
        //树状数组管理的元素数量
        int n;
        //树状数组j节点数据的数组，从1开始
        long[] t;
        BIT(int n){
            this.n=n;
            this.t=new long[n+2];
        }
        //单点更新i
        void add(int i,int delta){
            for(;i<=n;i+=i&-i){
                t[i]+=delta;
            }
        }
        //查询前缀和
        long sum(int i){
            long s=0;
            for(;i>0;i-=i&-i){
                s+=t[i];
            }
            return s;
        }
    }

    //把矩阵按顺时针螺旋读成一维序列
    static int[] spiral(int[][] edges){
        int n = edges.length;
        int[] a=new int[n*n];
        int k=0,top=0,bottom=n-1,left=0,right=n-1;
        while(top<=bottom&&left<=right){
            for(int j=left;j<=right;j++) a[k++]=edges[top][j];
            top++;
            for(int j=top;j<=bottom;j++) a[k++]=edges[j][right];
            right--;
            for(int j=right;j>=left;j--) a[k++]=edges[bottom][j];
            bottom--;
            for(int j=bottom;j>=top;j--) a[k++]=edges[j][left];
            left++;
        }
        return a;
    }
}
