import java.util.*;
public class HUAWEI061802 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<version> s=new ArrayList<>();
        for(int i=0;i<n;i++){
            String raw=sc.nextLine();
            s.add(new version(raw));
        }
        Collections.sort(s);
        String str=sc.nextLine();

    }

    static class version implements Comparable<version>{
        int major,minor,patch;
        String origion;

        //构造函数没有返回值声明
        public version(String origion) {
            this.origion = origion;
            String[] parts=origion.split("\\.");
            this.major=Integer.parseInt(parts[0]);
            this.minor=parts.length>1?Integer.parseInt(parts[1]):0;
            this.patch=parts.length>2?Integer.parseInt(parts[2]):0;
        }

        //调用Comparable<T>接口一定要实现CompareTo方法
        @Override
        public int compareTo(version o) {
            if(this.major!=o.major) return this.major-o.major;
            if(this.minor!=o.minor) return this.minor-o.minor;
            return this.patch-o.patch;
        }
    }
}
