package Exam.JingDong;

import java.io.*;
import java.util.*;

public class JingDong092001 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        String s = fs.next();
        int m = n / 2;          // 块数
        final int DIG = 10;
        final int INF = 1_000_000_000;

        int[] dpPrev = new int[DIG];
        int[] dpCur  = new int[DIG];
        Arrays.fill(dpPrev, INF);
        Arrays.fill(dpCur, INF);

        for (int k = 0; k < m; k++) {
            int a = s.charAt(2 * k) - '0';
            int b = s.charAt(2 * k + 1) - '0';

            // cost[v] = 本块变成 [v,v] 的代价
            int[] cost = new int[DIG];
            for (int v = 0; v < DIG; v++) {
                int c = 0;
                if (a != v) c++;
                if (b != v) c++;
                cost[v] = c; // 0/1/2
            }

            if (k == 0) {
                for (int v = 0; v < DIG; v++) dpCur[v] = cost[v];
            } else {
                for (int v = 0; v < DIG; v++) {
                    int best = INF;
                    for (int u = 0; u < DIG; u++) {
                        if (u == v) continue;     // 相邻块取值不同
                        if (dpPrev[u] < best) best = dpPrev[u];
                    }
                    dpCur[v] = best + cost[v];
                }
            }

            //上一轮结果变成下一轮输入
            int[] tmp = dpPrev; dpPrev = dpCur; dpCur = tmp;
            Arrays.fill(dpCur, INF);
        }
        int ans = INF;
        for (int v = 0; v < DIG; v++) ans = Math.min(ans, dpPrev[v]);
        System.out.println(ans);
    }

    // 简单快速读入
    static class FastScanner {
        BufferedInputStream in;
        byte[] buffer = new byte[1 << 16];
        int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = new BufferedInputStream(is); }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1 && Character.isWhitespace(c));
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = read()) != -1 && !Character.isWhitespace(c));
            return sb.toString();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}

