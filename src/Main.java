//import java.io.*;
//import java.util.*;
//
//public class Main {
//
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
//        int nextInt() throws IOException {
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
//            int val = 0;
//            while (c > ' ') {
//                val = val * 10 + (c - '0');
//                c = read();
//            }
//            return val * sign;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        FastScanner fs = new FastScanner();
//        StringBuilder out = new StringBuilder();
//
//        int T = fs.nextInt();
//        while (T-- > 0) {
//            int n = fs.nextInt();
//
//            int[] childCount = new int[n + 1];
//            for (int i = 2; i <= n; i++) {
//                int p = fs.nextInt();
//                childCount[p]++;
//            }
//
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int i = 1; i <= n; i++) {
//                if (childCount[i] > 0) {
//                    list.add(childCount[i]);
//                }
//            }
//
//            // 降序排序，优先启动大的孩子集合
//            list.sort(Collections.reverseOrder());
//
//            int m = list.size();
//            int[] cnt = new int[m + 1];
//            for (int i = 1; i <= m; i++) {
//                cnt[i] = list.get(i - 1);
//            }
//
//            int left = 0, right = n, ans = n;
//
//            while (left <= right) {
//                int mid = (left + right) >>> 1;
//                if (check(mid, n, cnt, m)) {
//                    ans = mid;
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//
//            out.append(ans).append('\n');
//        }
//
//        System.out.print(out);
//    }
//
//    static boolean check(int T, int n, int[] cnt, int m) {
//        // 至少要有一次点名根
//        if (T == 0) return false;
//
//        int available = T - 1; // 除去点名根后，剩下可用于孩子集合的点名次数
//        int g = Math.min(available, m);
//
//        long base = 0;
//        for (int i = 1; i <= g; i++) {
//            // 第 i 个集合在第 i 次时刻被启动
//            base += Math.min(cnt[i], 1 + (T - i));
//        }
//
//        long extra = Math.max(0, available - m);
//        long knownChildren = Math.min((long) n - 1, base + extra);
//
//        long totalKnown = 1 + knownChildren; // +1 表示根
//        return totalKnown >= n;
//    }
//}