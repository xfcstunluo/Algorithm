import java.util.*;
public class HUAWEI062501 {
    public static int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] matrix = new int[m][n];
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        List<int[]> pos=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pos.add(new int[]{matrix[i][j],i,j});
            }
        }
        pos.sort(Comparator.comparingInt(a->a[0]));
        for(int[] tmp:pos){
            int a=tmp[0];
            int i=tmp[1];
            int j=tmp[2];
            dp[i][j]=1;
            for(int k=0;k<4;k++){
                int x=i+dirs[k][0];
                int y=j+dirs[k][1];
                if(x>=0 && x<m && y>=0 && y<n && a>matrix[x][y]){
                    dp[i][j]=Math.max(dp[i][j],dp[x][y]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res,dp[i][j]);
            }
        }
        System.out.println(res);

    }
}
