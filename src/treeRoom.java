import java.util.*;
public class treeRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            //房间总数
            int n = sc.nextInt();
            int[] rooms=new int[n];
            for(int i=1;i<n;i++){
                rooms[i]=sc.nextInt();
            }
            int ans=0;
            int tmp=1;
            for(int i=2;i<n;i++){
                if(rooms[i]==rooms[i-1]){
                    tmp++;
                }else{
                    ans=Math.max(ans,tmp);
                    tmp=1;
                }
            }
            System.out.println(ans+1);
        }

    }
}
