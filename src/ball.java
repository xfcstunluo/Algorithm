import java.util.*;
public class ball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        int[] ballHeight= new int[n];
        List<int[]> allBall = new ArrayList<>();
        for(int i = 0; i < n; i++){
            allBall.add(new int[20]);
        }
        for(int i = 0; i < n; i++) {
            arr[i]=(double)(7-i)/8;
            ballHeight[i] = 100;
        }
        for(int i = 0; i < n; i++) {
            int sum=0;
            while(ballHeight[i]>5){
                if(ballHeight[i]*arr[i]-(int)(ballHeight[i]*arr[i])!=0) ballHeight[i]=(int)(ballHeight[i]*arr[i])+1;
                else ballHeight[i]=(int)(ballHeight[i]*arr[i]);
                sum++;
                if(ballHeight[i]<20){
                    allBall.get(i)[ballHeight[i]]=sum;
                }
            }
        }

        //输出：5-20，开区间，每个球在第几次出现在这个高度
//        for(Map.Entry<Integer, List<int[]>> entry : m.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(Arrays.toString(entry.getValue().toArray()));
//        }
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int i = 6; i < 20; i++) {
            boolean flag = true;
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(allBall.get(j)[i]!=0){
                    tmp.add(allBall.get(j)[i]);
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) m.put(i,tmp);
        }
        System.out.println("===2个球的情况===");
        for(int i = 6; i < 20; i++) {
            if(m.containsKey(i)){
                List<Integer> tmpHeight= m.get(i);
//                System.out.print("高度"+i+"米：分别为球"+);
            }
        }
    }
}
