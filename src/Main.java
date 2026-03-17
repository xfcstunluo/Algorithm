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
//    static int n;
//    static int[] to;
//    static List<Integer>[] rev;
//    static boolean[] inCycle;
//    static boolean[] visCycle;
//
//    public static void main(String[] args) throws Exception {
//        FastScanner fs = new FastScanner();
//        n = fs.nextInt();
//
//        to = new int[n];
//        rev = new ArrayList[n];
//        for (int i = 0; i < n; i++) rev[i] = new ArrayList<>();
//
//        int[] indeg = new int[n];
//        for (int i = 0; i < n; i++) {
//            to[i] = fs.nextInt();
//            rev[to[i]].add(i);
//            indeg[to[i]]++;
//        }
//
//        // 1) 拓扑剥叶，剩下的就是环上节点
//        inCycle = new boolean[n];
//        Arrays.fill(inCycle, true);
//
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            if (indeg[i] == 0) q.offer(i);
//        }
//
//        while (!q.isEmpty()) {
//            int u = q.poll();
//            inCycle[u] = false;
//            int v = to[u];
//            indeg[v]--;
//            if (indeg[v] == 0) q.offer(v);
//        }
//
//        // 2) 找所有环
//        visCycle = new boolean[n];
//        int maxCycle = 0;
//        int sumPairChains = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (inCycle[i] && !visCycle[i]) {
//                List<Integer> cycle = new ArrayList<>();
//                int cur = i;
//                while (!visCycle[cur]) {
//                    visCycle[cur] = true;
//                    cycle.add(cur);
//                    cur = to[cur];
//                }
//
//                int size = cycle.size();
//                if (size == 2) {
//                    int u = cycle.get(0);
//                    int v = cycle.get(1);
//
//                    int left = longestChain(u, v);
//                    int right = longestChain(v, u);
//
//                    sumPairChains += left + right + 2;
//                } else {
//                    maxCycle = Math.max(maxCycle, size);
//                }
//            }
//        }
//
//        System.out.println(Math.max(maxCycle, sumPairChains));
//    }
//
//    // 求指向 root 的最长链长度（不允许经过 ban，且不能走环上的其他点）
//    static int longestChain(int root, int ban) {
//        int best = 0;
//        for (int pre : rev[root]) {
//            if (pre == ban || inCycle[pre]) continue;
//            best = Math.max(best, dfs(pre));
//        }
//        return best;
//    }
//
//    // 在反图树上求最大深度
//    static int dfs(int u) {
//        int best = 1; // 当前节点自己算 1
//        for (int pre : rev[u]) {
//            if (inCycle[pre]) continue;
//            best = Math.max(best, 1 + dfs(pre));
//        }
//        return best;
//    }
//}