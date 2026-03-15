package WrittenExam.PDD;//前缀和+二分
import java.util.*;
public class PDD092804 {
    static final int INF=(int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //每条鱼的血量
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        //当前鱼血量大于相邻鱼时，能吃，且增加血量；若没有任何一条鱼血量大于它的邻居，return；
        int[] p=new int[n+1];
        for(int i=1;i<=n;i++){
            p[i]=p[i-1]+a[i];
        }

        //预处理相等段边界[5,5,5]
        int[] leftRun=new int[n+1];
        int[] rightRun=new int[n+1];
        leftRun[1]=1;
        //相等值的最左边位置，存的是索引值
        for(int i=2;i<=n;i++){
            if(a[i]==a[i-1]) leftRun[i]=leftRun[i-1];
            else leftRun[i]=i;
        }

        //相等值最右边位置，存的是索引值
        rightRun[n]=n;
        for(int i=n-1;i>=1;i--){
            if(a[i]==a[i+1]) rightRun[i]=rightRun[i+1];
            else rightRun[i]=i;
        }

        int[] ans=new int[n+1];
        for(int i=1;i<=n;i++){
            int best=INF;
            //对第i条鱼，从左边找一段最短连续鱼块[l,i-1]，让其合成一条鱼后可以吃掉鱼i
            if(i>1&&p[i-1]>a[i]){
                //区间前缀和，p[i-1]-p[l-1]>a[i]，要找最靠近右边的l
                int target=p[i-1]-a[i];
                //找到一个最大的l-1，使得p[l-1]<target
                //找第一个>=target的位置
                int x=lowerBound(p,0,i-1,target);
                //最右边l-1=x-1
                int l=x;
                int len=i-1-l+1;

                //如果长度>=2，说明前面的鱼块[l,i-1]可能存在重叠，若l>=最左边的位置，说明l在相等值区间上，则向左扩1个不同值
                if(len>=2&&l>=leftRun[i-1]){
                    if(leftRun[i-1]>1){
                        l=leftRun[i-1]-1;
                        len=i-l;
                    }else{
                        //无法再向左扩充，[l,i-1]吃不了鱼i了
                        len=INF;
                    }
                }
                best=Math.min(best,len);

            }

            //从右边找一段连续的块[i+1,r]，让其合成一条鱼后可以吃掉鱼i
            if(i<n&&p[n]-p[i]>a[i]){
                //p[r]-p[i]>a[i]
                int target=a[i]+p[i];
                //找到一个最小的r，使得p[r]>target
                int r=upperBound(p,i+1,n,target);
                int len=r-(i+1)+1;

                if(len>=2&&r<=rightRun[i+1]){
                    if(rightRun[i+1]<n){
                        r=rightRun[i+1]+1;
                        len=r-(i+1)+1;
                    }else len=INF;
                }
                best=Math.min(best,len);
            }
            ans[i]=(best==INF?-1:best);

        }
        //每条鱼，被其它鱼吃掉所需的最少次数，不可能被吃掉输出-1；
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            if(i>1) sb.append(' ');
            sb.append(ans[i]);
        }
        System.out.println(sb);
    }

    //在p[l,r]中找第一个>=target的位置
    public static int lowerBound(int[] p,int left,int right,int target){
        while(left<=right){
            int mid=(left+right)/2;
            if(p[mid]>=target) right=mid-1;
            else left=mid+1;
        }
        return left;
    }

    //在p[l,r]中找第一个>target的位置
    public static int upperBound(int[] p,int left,int right,int target){
        while(left<=right){
            int mid=(left+right)/2;
            if(p[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
}
