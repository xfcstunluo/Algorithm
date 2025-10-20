package Exam.DianXin;

import java.util.*;
public class DianXin092801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int sum=0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]=='b'||arr[i]=='p'||arr[i]=='q'||arr[i]=='d') sum++;
        }
        System.out.println(sum);
    }
}
