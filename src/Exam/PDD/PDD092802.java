package Exam.PDD;

import java.util.*;
public class PDD092802 {
    public static int num=0;
    public static int n;
    public static int[] inital;
    public static int[] target;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        inital = new int[n];
        for (int i = 0; i < n; i++) {
            inital[i] = sc.nextInt();
        }
        target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }
        //0表示该节点没有彩灯，颜色控制器点击一次，当前彩灯及以当前彩灯为根的所有子树切换到下一个颜色；
        dfs(0,0);
        //输出：最少点击次数
        System.out.println(num);
    }
    public static void dfs(int i,int lazy){
        if(inital[i]==0) return;
        int l=2*i+1,r=2*i+2;
        if(l>=n&&r>=n){
            inital[i]=(inital[i]+lazy)%5;
            num+=(target[i]+5-inital[i])%5;
            return;
        }
        inital[i]=(inital[i]+lazy)%5;
        num+=(target[i]+5-inital[i])%5;
        lazy+=(target[i]+5-inital[i])%5;
//        target[i]+=lazy;
        if(l<n) dfs(l,lazy);
        if(r<n) dfs(r,lazy);
    }
}
