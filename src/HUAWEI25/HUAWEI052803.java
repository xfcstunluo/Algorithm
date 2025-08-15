package HUAWEI25;

import java.util.*;
public class HUAWEI052803 {
    static int[][] Mapping={{0,1},{0,-1},{1,0},{-1,0}};
    static int maxVal=Integer.MIN_VALUE;
    static int minVal=Integer.MAX_VALUE;
    static int minPath=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ability=sc.nextInt();
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[][] matrix=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        //从0开始，要到最大值，最小需要移动的次数；
        //先找到最大值
        //判断：是否可以移动到该点？，dfs贪心；四个方向都要走，但不能回到原点。原点需要置空，再回溯；
        int min_i=0;
        int min_j=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                maxVal=Math.max(maxVal,matrix[i][j]);
                minVal=Math.min(minVal,matrix[i][j]);
                if(minVal==matrix[i][j]){
                    min_i=i;
                    min_j=j;
                }
            }
        }

        int cost=0;
        Deque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{min_i,min_j,cost});
        boolean[][] visited=new boolean[row][col];
        visited[min_i][min_j]=true;
        boolean flag=false;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int i=arr[0];
            int j=arr[1];
            int curCost=arr[2];

            if(matrix[i][j]==maxVal){
                flag=true;
                minPath=curCost;
                break;
            }
            for(int k=0;k<4;k++){
                int x=i+Mapping[k][0];
                int y=j+Mapping[k][1];
                if(x>=0&&x<row&&y>=0&&y<col&&!visited[x][y]){
                    if(Math.abs(matrix[i][j]-matrix[x][y])<=ability){
                        visited[x][y]=true;
                        q.offer(new int[]{x,y,curCost+1});
                    }
                }
            }
        }
        System.out.println(flag?minPath:-1);
    }


}
