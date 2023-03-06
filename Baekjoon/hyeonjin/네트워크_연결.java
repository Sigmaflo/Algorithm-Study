import java.io.*;
import java.util.*;

public class 네트워크_연결 {
    static int N;
    static int M;
    static List<Edge> edges = new ArrayList<>();
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        parents = new int[N + 1];
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(str.nextToken());
            int b = Integer.valueOf(str.nextToken());
            int c = Integer.valueOf(str.nextToken());

            edges.add(new Edge(a,b,c));
        }
        Collections.sort(edges);

        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        kruskal();
    }

    private static void kruskal() {
        int cnt = 0;
        int result = 0;

        for(int i = 0; i < M; i++) {
            Edge edge = edges.get(i);

            if(!isCycle(edge.x, edge.y)) {
                cnt++;
                result += edge.cost;
            }


            if(cnt == N - 1) continue;
        }

        System.out.println(result);
    }

    private static boolean isCycle(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a == b) return true;
        parents[a] = b;
        return false;

    }

    private static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
