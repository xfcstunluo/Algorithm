package writtenExam;

import java.util.*;
public class MeiTuan040501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            long n=sc.nextLong();
            long m=sc.nextLong();
            int w2=sc.nextInt();
            int w3=sc.nextInt();
            Long val=Long.MAX_VALUE;
            for(int i=1;i<=31;i++){
                long pow2=(long)2<<i;
                if(n*pow2>=m){
                    val=Math.min(val,i*w2);
                    break;
                }
                long count2=i*w2;
                long ans=1;
                for(int j=1;j<=31;j++){
                    long pow3=ans*3;
                    if(n*pow2*pow3>=m){
                        val=Math.min(val,i*w2+j*w3);
                        break;
                    }
                }
            }
            System.out.println(val);
        }
    }
}
