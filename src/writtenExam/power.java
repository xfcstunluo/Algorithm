package writtenExam;

import java.util.*;
public class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建了n座磁力站
        int n = sc.nextInt();
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int eightStation=0;
            int station=0;
            q.add(new int[]{x, y});
            PriorityQueue<int[]> tmp=q;
            while(!tmp.isEmpty()){
                int[] a = tmp.poll();
                if(!tmp.isEmpty()){
                    if(tmp.size()==1){
                        int[] b = tmp.peek();
                        if(Math.abs(a[0]-b[0])<=1&&Math.abs(a[1]-b[1])<=1) eightStation+=2;
                        else station+=2;
                    }else{
                        int[] b = tmp.peek();
                        if(Math.abs(a[0]-b[0])<=1&&Math.abs(a[1]-b[1])<=1) eightStation++;
                        else station++;
                    }
                }else station++;
            }
            long sum=0;
            sum=eightStation*eightStation+station;
            System.out.println(sum);
        }

    }
}


//4
//        0 0
//        2 3
//        1 1
//        2 2
//
//
//        1
//        2
//        5
//        16