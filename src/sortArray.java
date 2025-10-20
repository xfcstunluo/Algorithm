import java.util.*;
public class sortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        char[] arr=str.toCharArray();
        List<Character> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        List<Character> tmp=new ArrayList<>();
        boolean flag=true;
        int ans=0;
        while(flag){
            flag=false;
            boolean[] visited=new boolean[list.size()];
            for(int i=0;i<list.size()-1;i++){
                if(!visited[i+1]&&list.get(i)!=list.get(i+1)){
                    ans++;
                    visited[i+1]=true;
                    flag=true;
                }
            }
            for(int i=0;i<list.size();i++){
                if(!visited[i]) tmp.add(list.get(i));
            }
            list.clear();
            list=new ArrayList<>(tmp);
            tmp.clear();
        }
        System.out.println(ans);
    }
}
