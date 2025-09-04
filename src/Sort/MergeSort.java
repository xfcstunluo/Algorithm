package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5, 2, 9, 1, 6, 3};
        int n=arr.length;
        int[] tmp=new int[n];
        mergeSort(arr,tmp,0,n-1);
        System.out.println(Arrays.toString(tmp));
    }
    public static void mergeSort(int[] arr,int[] tmp,int l,int r){
        if(l>=r) return;
        int m=l+(r-l)/2;
        mergeSort(arr,tmp,l,m);
        mergeSort(arr,tmp,m+1,r);
        if(arr[m]<arr[m+1]) return;
        int i=l,j=m+1,k=l;
        while(i<=m&&j<=r){
            if(arr[i]<=arr[j]) tmp[k++]=arr[i++];
            else tmp[k++]=arr[j++];
        }
        while(i<=m) tmp[k++]=arr[i++];
        while(j<=r) tmp[k++]=arr[j++];
        for(int p=l;p<=r;p++) arr[p]=tmp[p];
        return;
    }
}
