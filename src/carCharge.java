import java.util.*;
public class carCharge {
    public static int INF=1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //先到先服务，同时到达则按车辆编号优先；优先用编号最小的充电桩，若被占用需要排队等待；
        //n辆车
        int n = sc.nextInt();
        //k个充电桩
        int k = sc.nextInt();
        int[] s=new int[k];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return a[2]-b[2];
        });
        for(int i=0; i<n; i++) {
            int arrivalTime = sc.nextInt();
            int chargingTime = sc.nextInt();
            heap.add(new int[]{arrivalTime, chargingTime,i});
        }
        for(int i=0;i<=INF;i++){
            if(heap.isEmpty()) break;
            if(s[0]==0||s[1]==0){
                if(heap.peek()[0]<=i){
                    int[] cur = heap.poll();
                    int carId = cur[2];
                    int beginCharging = i;
                    int endCharging = i + cur[1];
                    if (s[0] == 0) {
                        s[0] = cur[1];
                        if (s[1] != 0) s[1]--;
                        s[0]--;
                        int charge = 1;
                        System.out.println(carId + " " + beginCharging + " " + endCharging + " " + charge);
                        continue;
                    }
                    if (s[1] == 0) {
                        s[1] = cur[1];
                        if (s[0] != 0) s[0]--;
                        s[1]--;
                        int charge = 2;
                        System.out.println(carId + " " + beginCharging + " " + endCharging + " " + charge);
                        continue;
                    }
                }else{
                    if(s[0]!=0) s[0]--;
                    if(s[1]!=0) s[1]--;
                }
            }else{
                s[0]--;
                s[1]--;
            }
        }



        //输出：车辆编号、开始充电时间、结束充电时间、充电桩编号
    }
}
