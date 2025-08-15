package HUAWEI25;

import java.util.*;
public class HUAWEI062503 {
    public static int[][] dirs={{-1,1},{0,1},{1,1},{-1,0},{1,0},{0,-1},{-1,-1},{1,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[][]visited=new boolean[m][n];
        Deque<int[]> q=new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1&&visited[i][j]==false){
                    visited[i][j]=true;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        int a=cur[0],b=cur[1];
                        for(int k=0;k<8;k++){
                            int x=a+dirs[k][0];
                            int y=b+dirs[k][1];
                            if(x>=0&&x<m&&y>=0&&y<n&&matrix[x][y]==1&&visited[x][y]==false){
                                visited[x][y]=true;
                                q.add(new int[]{x,y});
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        int sum=1;
        sum=ans*(ans-1)/2;
        System.out.println(sum);
    }
}
