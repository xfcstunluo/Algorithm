import java.util.*;
import java.util.stream.Collectors;

public class dictionaryForWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String s=str.substring(0,str.length()-1);
        String[] words=s.split(" ");
        PriorityQueue<String> heap=new PriorityQueue<>((a,b)->{
            if(a.length()==b.length()){
                for(int i=a.length()-1;i>=0;i--){
                    if(a.charAt(i)!=b.charAt(i)){
                        return a.charAt(i)-b.charAt(i);
                    }
                }
            }
            return b.length()-a.length();
        });
        List<String> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            heap.add(words[i]);
        }
        while(!heap.isEmpty()){
            list.add(heap.poll());
        }
        System.out.println(list.stream().collect(Collectors.joining(" ")));
    }
}
