package Exam.YongYou;

import java.util.*;
public class YongYou101701 {
    //求所有球在跳了多少次之后能够在相同高度的题
    public static class Ball {
        //p/q，先用double会有精度问题，合在一起最后算
        int p, q = 8;
        Ball(int p) { this.p = p; }
        // 下一个高度：ceil(h * p / q)
        int next(int h) { return (h * p + q - 1) / q; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            balls[i] = new Ball(7 - i);
        }
        //第 i 个球第一次达到高度 h (6..19) 的回弹次数；0 表示没到过
        int[][] first = new int[n][20];
        for (int i = 0; i < n; i++) {
            int h = 100;
            int k = 0; // 回弹次数
            while (h > 5) {
                h = balls[i].next(h);
                k++;
                if (h >= 6 && h <= 19 && first[i][h] == 0) {
                    //只记录第一次
                    first[i][h] = k;
                }
            }
        }
        // 找所有球都能到达的高度
        Map<Integer, List<Integer>> common = new LinkedHashMap<>();
        for (int h = 6; h <= 19; h++) {
            boolean ok = true;
            List<Integer> steps = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (first[i][h] == 0) { ok = false; break; }
                steps.add(first[i][h]);
            }
            if (ok) common.put(h, steps);
        }

        //输出：5-20，开区间，每个球在第几次出现在这个高度
        System.out.println("=== " + n + " 个球的情况 ===");
        for (Map.Entry<Integer, List<Integer>> e : common.entrySet()) {
            int h = e.getKey();
            List<Integer> steps = e.getValue();
            System.out.print("高度 " + h + " 米：");
            for (int i = 0; i < steps.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print("球" + (i+1) + " 第 " + steps.get(i) + " 次回弹");
            }
            System.out.println();
        }
    }
}
