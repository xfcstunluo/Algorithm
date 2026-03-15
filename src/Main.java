//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    // 更快的输入
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
//            } while (c <= ' ');
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
//        StringBuilder sb = new StringBuilder();
//
//        int T = fs.nextInt();
//        while (T-- > 0) {
//            int n = fs.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = fs.nextInt();
//            }
//
//            // 1) 找最左的 r，使得 a[r...n-1] 无重复
//            HashSet<Integer> suf = new HashSet<>();
//            int r = n;
//            while (r - 1 >= 0 && !suf.contains(a[r - 1])) {
//                suf.add(a[r - 1]);
//                r--;
//            }
//
//            int ans = r; // 删掉前缀 [0...r-1]
//
//            // 2) 从左往右扩展前缀
//            HashSet<Integer> pre = new HashSet<>();
//            for (int l = 0; l < n; l++) {
//                // 前缀内部出现重复，后面无需继续
//                if (pre.contains(a[l])) {
//                    break;
//                }
//                pre.add(a[l]);
//
//                // 若新加入的前缀元素与后缀冲突，右移 r
//                while (r < n && suf.contains(a[l])) {
//                    suf.remove(a[r]);
//                    r++;
//                }
//
//                // 删除区间 [l+1 ... r-1]
//                ans = Math.min(ans, r - (l + 1));
//            }
//
//            sb.append(ans).append('\n');
//        }
//
//        System.out.print(sb);
//    }
//}