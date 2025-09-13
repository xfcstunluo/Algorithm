package writtenExam.XinGuoDu;
/**
 * 有序对称数
 * 一个数组由数字和0组成，满以下条件，称为有序对称数串：
 * 1）对于每一个数a,后面都有一个-a与之对应，称为对称的，其中a不等于0
 * 2）对于每一组对称的数，如果前面的数总是小于后面的数，则称为有序的。
 * 3）任何一组对称的数不能与其它的对称数交叉，但可以包含绝对值比他小的数对
 * 长度为n：满足 0 <= n <=100
 */
import java.util.*;

public class XinGuoDu02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine().trim();
        if (inputStr.length() < 2) { System.out.println(true); return; } // 空串视为合法
        inputStr = inputStr.substring(1, inputStr.length() - 1);
        if (inputStr.trim().isEmpty()) { System.out.println(true); return; }

        String[] split = inputStr.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i].trim());
        }
        System.out.println(isSymmetric(nums));
    }

    static boolean isSymmetric(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int x : nums) {
            if (x == 0) continue;
            if (x < 0) {
                int a = -x;
                if (!st.isEmpty() && a >= st.peek()) {
                    //负数小绝对值更大
                    return false;
                }
                st.push(a);
            } else {
                int a = x;
                if (st.isEmpty() || st.peek() != a) {
                    //与最近未闭合的 -a 匹配，且反交叉
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
