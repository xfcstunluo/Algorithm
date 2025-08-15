package HUAWEI25;

import java.util.*;

public class HUAWEI04090302 {
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
        int[] tmp=new int[N*N];
        long ans=mergeSort(res,tmp,0,N*N-1);
        System.out.println(ans%MOD);
    }

    //归并排序
    static long mergeSort(int[] arr,int[] tmp,int l,int r){
        if(l>=r) return 0;
        //防整数溢出
        int m=l+(r-l)/2;
        long cnt=0;
        cnt+=mergeSort(arr,tmp,l,m);
        cnt+=mergeSort(arr,tmp,m+1,r);
        //剪枝：如果已经有序，跳过合并
        if(arr[m]<=arr[m+1]) return cnt;
        int i=l,j=m+1,k=l;
        while(i<=m&&j<=r){
            if(arr[i]<=arr[j]){
                tmp[k++]=arr[i++];
            }else{
                tmp[k++]=arr[j++];
                //[i,m]区间中所有数都是逆序对
                cnt+=(m-i+1);
            }
        }
        while(i<=m) tmp[k++]=arr[i++];
        while(j<=r) tmp[k++]=arr[j++];
        //写回原数组
        for(int p=l;p<=r;p++){
            arr[p]=tmp[p];
        }
        return cnt;
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
            if (top <= bottom)
                for(int j=right;j>=left;j--) a[k++]=edges[bottom][j];
            bottom--;
            if (left <= right)
                for(int j=bottom;j>=top;j--) a[k++]=edges[j][left];
            left++;
        }
        return a;
    }
}
