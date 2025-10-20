import java.util.*;
public class computeShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //0表示未领取优惠券，1表示领到优惠券，相邻用户不能同时领到；
        //n，判断能否在遵循领取规则的情况下再发放n张优惠券
        String[] s = sc.nextLine().split(",");
        int lens=s.length;
//        int[] nums=new int[lens];
//        for(int i=0;i<lens;i++){
//            nums[i]=Integer.parseInt(s[i]);
//        }
        int n=sc.nextInt();
        int k=0;
        for(int i=0;i<lens;i++){
            if(i==0&&s[i].equals("0")&&s[i+1].equals("0")){
                s[i]="1";
                k++;
            }else if(i>0&&i<lens-1&&s[i-1].equals("0")&&s[i+1].equals("0")&&s[i].equals("0")){
                s[i]="0";
                k++;
            }else if(i==lens-1&&s[i-1].equals("0")&&s[i].equals("0")){
                s[i]="0";
                k++;
            }
        }
        if(k>=n) System.out.println("true");
        else System.out.println("false");



        //输出：true/f
    }
}
