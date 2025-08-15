package HUAWEI25;

import java.util.*;
public class HUAWEI042302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数组长度
        int n = sc.nextInt();
        int[] initial= new int[n];
        int[] target= new int[n];
        for(int i=0;i<n;i++){
            //-1方便取模
            initial[i]=sc.nextInt()-1;
        }
        for(int i=0;i<n;i++){
            target[i]=sc.nextInt()-1;
        }
        //值为-1时节点不存在
        //红1，绿2，蓝3，按下某个节点的按钮，以该节点为根节点的子树上的值顺延一位
        int result=dfs(initial,target,n,0,0);
        //输出：最少开关切换次数
        System.out.println(result);
    }

    //u父节点索引，op需要操作的次数
    public static int dfs(int[] initial,int[] target,int n,int u,int op){
        if(u>=n) return 0;
        if(initial[u]==-1) return 0;
        //懒标记,此时更新该节点的真实值
        int realVal=(initial[u]+op)%3;
        //以该点为根节点，需要再操作几次与期望值相同
        //b<a  a-b;
        //b>a  2,1 a-b+3
        int opVal=(target[u]-realVal+3)%3;
        op+=opVal;
        int left=u*2+1;
        int right=u*2+2;
        return opVal+dfs(initial,target,n,left,op)+dfs(initial,target,n,right,op);
    }

}
