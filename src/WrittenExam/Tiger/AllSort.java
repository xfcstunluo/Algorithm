package WrittenExam.Tiger;

import java.util.*;
import java.util.stream.Collectors;

public class AllSort {
    //全排列
    public static List<List<Integer>> ans=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s=str.substring(1,str.length()-1).split(",");
        int n=s.length;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(s[i]);
        }
        List<Integer> path=new ArrayList<>();
        boolean[] visited=new boolean[n];
        dfs(0,nums,visited,path);
        System.out.print('[');
        for(int i=0;i<ans.size();i++){
            System.out.print('[');
            System.out.print(ans.get(i).stream().map(String::valueOf).collect(Collectors.joining(",")));
            System.out.print(']');
            if(i!=ans.size()-1) System.out.print(",");
        }
        System.out.print(']');
    }

    public static void dfs(int i,int[] nums,boolean[] visited,List<Integer> path){
        if(i==nums.length){
            if(!ans.contains(path)){
                ans.add(new ArrayList<>(path));
                return;
            }
        }
        for(int num=0;num<nums.length;num++){
            if(!visited[num]){
                visited[num]=true;
                path.add(nums[num]);
                dfs(i+1,nums,visited,path);
                path.remove(path.size()-1);
                visited[num]=false;
            }

        }
    }

}
