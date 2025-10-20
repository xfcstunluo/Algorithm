package Exam.DianXin;

import java.util.*;
public class DianXin092802 {

    public static void main(String[] args) {
        Map<Integer,Character> map = new HashMap<>();
        int p=1;
        for(char a='a';a<='z';a++){
            map.put(p++,a);
        }
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0) {
            List<int[]> res=new ArrayList<>();
            //三个小写字母和
            int n = sc.nextInt();
            //允许的邻差组合在int[k]中选
            int k = sc.nextInt();
            List<Integer> D=new ArrayList<>();
            for(int i=0;i<k;i++) {
                D.add(sc.nextInt());
            }
            //从a~z中取，若符合三个字母和为n，且差值在D中，入List
            for(int i=1;i<=26;i++){
                if(i>n) break;
                for(int j=1;j<=26;j++){
                    if(i+j>n) break;
                    for(int m = 1; m <=26; m++){
                        if(i+j+m==n){
                            if(D.contains(Math.abs(i-j))&&D.contains(Math.abs(j-m))){
                                res.add(new int[]{i,j,m});
                            }
                        }
                    }
                }
            }
            if(!res.isEmpty()) {
                Collections.sort(res,(a,b)->{
                    for(int i=0;i<3;i++){
                        if(a[i]!=b[i]) return a[i]-b[i];
                    }
                    return 0;
                });
                int[] cur=res.get(0);
                char[] tmp=new char[3];
                for(int i=1;i<3;i++){
                    tmp[i]=(char) ('a'+cur[i]);
                }
                int a=cur[0];
                StringBuilder s=new StringBuilder();
                s.append(map.get(cur[0]));
                s.append(map.get(cur[1]));
                s.append(map.get(cur[2]));
                System.out.println(s.toString());
            }else System.out.println("NO");

            //输出：所有合法单词中字典序最小的；没有则NO
        }
    }


}
