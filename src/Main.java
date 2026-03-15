//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static class FastScanner {
//        private final InputStream in = System.in;
//        private final byte[] buffer = new byte[1 << 16];
//        private int ptr = 0, len = 0;
//
//        private int read() throws IOException {
//            if (ptr >= len) {
//                len = in.read(buffer);
//                ptr = 0;
//                if (len <= 0) return -1;
//            }
//            return buffer[ptr++];
//        }
//
//        long nextLong() throws IOException {
//            int c;
//            do {
//                c = read();
//            } while (c <= ' ' && c != -1);
//
//            int sign = 1;
//            if (c == '-') {
//                sign = -1;
//                c = read();
//            }
//
//            long val = 0;
//            while (c > ' ') {
//                val = val * 10 + (c - '0');
//                c = read();
//            }
//            return val * sign;
//        }
//
//        int nextInt() throws IOException {
//            return (int) nextLong();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        FastScanner fs = new FastScanner();
//        int n = fs.nextInt();
//
//        long[] a = new long[n + 1];
//        for (int i = 1; i <= n; i++) {
//            a[i] = fs.nextLong();
//        }
//
//        // 前缀和，严格递增（因为 a[i] > 0）
//        long[] ps = new long[n + 1];
//        for (int i = 1; i <= n; i++) {
//            ps[i] = ps[i - 1] + a[i];
//        }
//
//        // 预处理相等段边界
//        int[] leftRun = new int[n + 1];
//        int[] rightRun = new int[n + 1];
//
//        leftRun[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            if (a[i] == a[i - 1]) {
//                leftRun[i] = leftRun[i - 1];
//            } else {
//                leftRun[i] = i;
//            }
//        }
//
//        rightRun[n] = n;
//        for (int i = n - 1; i >= 1; i--) {
//            if (a[i] == a[i + 1]) {
//                rightRun[i] = rightRun[i + 1];
//            } else {
//                rightRun[i] = i;
//            }
//        }
//
//        int INF = (int) 1e9;
//        int[] ans = new int[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            int best = INF;
//
//            // ---------- 从左边找 ----------
//            if (i > 1 && ps[i - 1] > a[i]) {
//                // 找最短 [l..i-1]，使 sum(l..i-1) > a[i]
//                // 即 ps[i-1] - ps[l-1] > a[i]
//                // => ps[l-1] < ps[i-1] - a[i]
//                long target = ps[i - 1] - a[i];
//                int l = lowerBound(ps, 0, i - 1, target); // l 即区间起点
//                int len = i - l; // [l..i-1] 长度
//
//                // 如果长度>=2且全相等，则需要再往左扩1个不同值
//                if (len >= 2 && l >= leftRun[i - 1]) {
//                    if (leftRun[i - 1] > 1) {
//                        l = leftRun[i - 1] - 1;
//                        len = i - l;
//                    } else {
//                        len = INF;
//                    }
//                }
//
//                best = Math.min(best, len);
//            }
//
//            // ---------- 从右边找 ----------
//            if (i < n && ps[n] - ps[i] > a[i]) {
//                // 找最短 [i+1..r]，使 sum(i+1..r) > a[i]
//                // 即 ps[r] - ps[i] > a[i]
//                // => ps[r] > ps[i] + a[i]
//                long target = ps[i] + a[i];
//                int r = upperBound(ps, i + 1, n, target);
//                int len = r - i; // [i+1..r] 长度
//
//                // 如果长度>=2且全相等，则需要再往右扩1个不同值
//                if (len >= 2 && r <= rightRun[i + 1]) {
//                    if (rightRun[i + 1] < n) {
//                        r = rightRun[i + 1] + 1;
//                        len = r - i;
//                    } else {
//                        len = INF;
//                    }
//                }
//
//                best = Math.min(best, len);
//            }
//
//            ans[i] = (best == INF ? -1 : best);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            if (i > 1) sb.append(' ');
//            sb.append(ans[i]);
//        }
//        System.out.println(sb);
//    }
//
//    // 在 ps[left..right] 中找第一个 >= target 的位置
//    static int lowerBound(long[] ps, int left, int right, long target) {
//        int l = left, r = right, ans = right + 1;
//        while (l <= r) {
//            int mid = (l + r) >>> 1;
//            if (ps[mid] >= target) {
//                ans = mid;
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return ans;
//    }
//
//    // 在 ps[left..right] 中找第一个 > target 的位置
//    static int upperBound(long[] ps, int left, int right, long target) {
//        int l = left, r = right, ans = right + 1;
//        while (l <= r) {
//            int mid = (l + r) >>> 1;
//            if (ps[mid] > target) {
//                ans = mid;
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return ans;
//    }
//}
