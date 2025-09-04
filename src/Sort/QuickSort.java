package Sort;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5, 2, 9, 1, 6, 3};
        quickSort(arr,0,arr.length-1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void quickSort(int[] nums,int left,int right){
        //l>=r判断、1个pivot，3个while
        if(left>=right) return;
        int pivot=patition(nums,left,right);
        quickSort(nums,left,pivot-1);
        quickSort(nums,pivot+1,right);
    }
    public static int patition(int[] nums,int left,int right){
        int i=left+1,j=right;
        while(i<=j){
            while (i<=right&&nums[left]>=nums[i]) i++;
            while(j>=left+1&&nums[left]<=nums[j]) j--;
            if(i<j) swap(nums,i,j);
        }
        swap(nums,left,j);
        return j;

    }
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

