import java.util.ArrayDeque;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int ans = numIslands(grid);
        System.out.println(ans);
    }

    public static int[][] Mapping={{1,0},{-1,0},{0,1},{0,-1}};
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q=new ArrayDeque<>();
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&visited[i][j]==false){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                    ans++;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        int a=cur[0],b=cur[2];
                        for(int k=0;k<4;k++){
                            int x=a+Mapping[k][0];
                            int y=b+Mapping[k][1];
                            if(x>=0&&x<m&&y>=0&&y<n&&visited[x][y]==false&&grid[x][y]=='1'){
                                visited[x][y]=true;
                                q.offer(new int[]{x,y});
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}