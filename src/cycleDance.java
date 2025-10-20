import java.util.*;
public class cycleDance {
    public static class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int val,Node next,Node pre){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Node cycle = new Node(nums[0]);
        for(int i = 1; i < n; i++){
            Node node=new Node(nums[i]);
            node.pre=cycle;
            node.next=cycle.next;
        }

        //输出：能参加表演最多的人数
    }
}
