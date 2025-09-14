package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2}; // 待排序数组
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        //n-1、n-1-i；swap；
        int n = arr.length;
        //外层循环控制趟数，每次把最大值冒到最后
        for (int i = 0; i < n - 1; i++) {
            //内层循环控制相邻元素比较与交换
            for (int j = 0; j < n - 1 - i; j++) {
                //如果前一个元素比后一个元素大，则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

