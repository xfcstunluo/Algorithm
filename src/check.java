import java.util.*;
public class check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        //2位大写字符，6位数字，1位校验位
        //前8位每个字符ascii码之和，26取余，+A的ascii
        char[] s=str.toCharArray();
        if(s.length!=9){
            System.out.print("Invalid");
            return;
        }
        for(int i=0;i<s.length-1;i++){
            if(i<=1){
                if(s[i]<64||s[i]>90){
                    System.out.print("Invalid");
                    return;
                }
            }
            else if(s[i]<48||s[i]>57){
                System.out.print("Invalid");
                return;
            }
        }
        int sum=0;
        for(int i=0;i<s.length-1;i++){
            sum+=s[i];
        }
        sum%=26;
        char ch=(char)(sum+65);
        if(ch==s[s.length-1]) System.out.println(str);
        else{
            s[s.length-1]=ch;
            StringBuilder newStr=new StringBuilder();
            for(int i=0;i<s.length;i++){
                newStr.append(s[i]);
            }
            System.out.println(newStr.toString());
        }

        //输出：修复后的快递单号， 无法修复返回Invalid；
    }
}
