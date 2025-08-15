package HUAWEI25;

import java.util.*;
public class HUAWEI041601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //用例总数
        int i=sc.nextInt();
        //代码模块总数
        int j=sc.nextInt();
        int[] rowMasks=new int[i];
        //每一行转化为位掩码，每一行作为一个测试用例
        for(int a = 0; a <i; a++){
            int m=0;
            for(int b=0; b <j; b++){
                int v=sc.nextInt();
                if(v==1) m|=(1<<b);
            }
            rowMasks[a]=m;
        }
        //第i个测试用例覆盖了第j个模块：1；else 0；
        //目标掩码
        int target=(1<<j)-1;
        int ans=Integer.MAX_VALUE;
        //二进制枚举选取哪些测试用例子集
        for(int k=0; k<(1<<i); k++){
            int unionMask=0;
            int cnt=0;
            //遍历子集中的所有测试用例
            for(int c=0;c<i;c++){
                if(((k&(1<<c))!=0)){
                    unionMask|=rowMasks[c];
                    cnt++;
                }
            }
            if(unionMask==target){
                ans=Math.min(ans,cnt);
            }
        }
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
        //输出:最小覆盖所有模块的测试用例集合，返回集合大小
        //特例：不存在能够覆盖所有模块的测试用例集合，返回-1
    }
}
