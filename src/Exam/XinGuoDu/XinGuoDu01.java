package Exam.XinGuoDu;

import java.util.*;

/**
 * 一个数组代表一组小孩的得分，规定每个小孩至少得到1颗糖果，任意两个相邻的小孩，得分较高的要比得分低的小孩糖果多。问最少需要多少糖果。
 */
public class XinGuoDu01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        // 解析输入 [1,0,2]
        String body = s.substring(1, s.length()-1).trim();
        String[] parts = body.split(",");
        int n = parts.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(parts[i]);

        // 1. 先全部给 1
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // 2. 从左到右，处理递增
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        // 3. 从右到左，处理递减，并计算总和
        int sum = candies[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (a[i] > a[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum += candies[i];
        }

        // 4. 输出结果
        System.out.println(sum);
    }
}
