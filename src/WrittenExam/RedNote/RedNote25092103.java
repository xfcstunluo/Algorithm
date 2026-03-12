package WrittenExam.RedNote;

import java.util.*;
public class RedNote25092103 {
    static class SegementTree{
        int n;
        //线段树名
        long[] maxTree;
        SegementTree(long[] arr){
            //前缀和有效
            this.n=arr.length-1;
            //线段树用4n大小的数组存保证足够安全
            this.maxTree=new long[n*4];
            build(1,1,n,arr);
        }

        void build(int idx,int l,int r,long[] arr){
            if(l==r){
                maxTree[idx]=arr[l];
                return;
            }
            int mid=(l+r)/2;
            //建左子树,idx<<1=idx*2
            build(idx<<1,l,mid,arr);
            //建右子树，idx<<1|1=idx*2+1
            build(idx<<1|1,mid+1,r,arr);
            //回溯时更新区间最大值
            maxTree[idx]=Math.max(maxTree[idx<<1],maxTree[idx<<1|1]);
        }

        //在区间[ql,n]中找第一个>target的位置，不存在返回n+1;
        int fistGreater(int ql,long target){
            return fistGreater(1,1,n,ql,target);
        }

        int fistGreater(int idx,int l,int r,int ql,long target){
            //区间里最大的数不超过target，更不可能有数能比target大
            if(r<ql||maxTree[idx]<=target) return n+1;
            //已经排除了两件事：ql还在区间中，它仍比target大，递归到叶节点则绝对满足
            if(l==r) return l;
            int mid=(l+r)>>>1;
            int left=fistGreater(idx<<1,l,mid,ql,target);
            if(left!=n+1) return left;
            return fistGreater(idx<<1|1,mid+1,r,ql,target);
        }
    }

    //二分找第一个>=l的位置
    static int findFistEQ(ArrayList<Integer> positions,int l,int n){
        if(positions==null||positions.isEmpty()) return n+1;
        int lo=0,hi=positions.size()-1;
        int ans=positions.size();
        while(lo<=hi){
            int mid=(lo+hi)>>>1;
            if(positions.get(mid)>=l){
                ans=mid;
                hi=mid-1;
            }else lo=mid+1;
        }
        return ans==positions.size()?n+1:positions.get(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //节点数量
        int n = sc.nextInt();
        //临界值
        long k = sc.nextLong();
        //每个节点的能量
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //每个节点为正/负能量，激活序列[l,r]时，计算从起始位置到区间内每一个位置的能量总和，将最大者作为峰值，只有峰值等于临界值时，才能激活核心
        //计算前缀和P[0..n]
        long[] prefix=new long[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+arr[i-1];
        }
        //要满足max(P[i]-P[l-1])=k，则max(P[i])=p[l-1]+k；
        //以哈希表存相同前缀和的所有位置
        Map<Long,ArrayList<Integer>> posMap=new HashMap<>();
        for(int i=1;i<=n;i++){
            posMap.computeIfAbsent(prefix[i],key->new ArrayList<>()).add(i);
        }

        //线段树利用区间最值判断某区间内有无>T的数，没有则跳过，有则优先往左找位置。
        SegementTree sg=new SegementTree(prefix);
        long ans=0;
        for(int l=1;l<=n;l++){
            long target=prefix[l-1]+k;
            //二分查找第一个等于target的数
            int postEQ=findFistEQ(posMap.get(target),l,n);
            if(postEQ==n+1) continue;
            int postGT=sg.fistGreater(l,target);
            if(postEQ<postGT){
                ans+=(long)(postGT-postEQ);
            }
        }
        //输出：所有能激活核心的区间数量
        System.out.println(ans);
    }
//0 2 -5 4 -3
}

