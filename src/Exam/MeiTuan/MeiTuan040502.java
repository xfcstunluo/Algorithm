package Exam.MeiTuan;

import java.util.*;
public class MeiTuan040502 {
    public static int N=5000000;
    public static boolean[] Prime=new boolean[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        System.out.println(sum);
    }

    public static void isPrime(int N){
        Arrays.fill(Prime,true);
        Prime[0]=Prime[1]=false;
        for(int i=2;i*i<=N;i++){
            if(Prime[i]){
                for(int j=i;j*j<=N;j+=i) Prime[j]=false;
            }
        }
    }
}
