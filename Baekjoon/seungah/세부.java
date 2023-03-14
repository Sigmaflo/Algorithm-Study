package Baekjoon.seungah;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 세부 {
    static int N, M;
    static int s, e;

    static int a, b, c;

    static class Edge implements Comparable<Edge>{
        int end, weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (this.weight - o.weight)* -1;//내림차순
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.valueOf(st.nextToken());
        e = Integer.valueOf(st.nextToken());

        // s에서 e까지 가는 경로 중에 최대로 갖고 갈 수 있는 빼빼로 수 (min(경로 가중치) 중에 가장 큰 값)
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];
        ArrayList<Edge> edges[] = new ArrayList[N+1];

        for (int i=0; i<=N; i++) {
            edges[i] = new ArrayList<Edge>();
        }

        dist[s] = Integer.MAX_VALUE;

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            c = Integer.valueOf(st.nextToken());

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        PriorityQueue <Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(s,0));

        while(!queue.isEmpty()){
            Edge cur = queue.poll();
            if(visit[cur.end]) continue; // 방문했으면 넘어감
            visit[cur.end] = true;

            for(int i=0; i<edges[cur.end].size(); i++) { // 현재 노드와 연결된 노드 전체 확인
                // System.out.println("next " + edges[cur.end].get(i).end + " cost: " + edges[cur.end].get(i).weight);
                int next = edges[cur.end].get(i).end; // 연결된 노드 도착지
                int cost = edges[cur.end].get(i).weight; // 연결된 노드까지 가는 가중치

                //
                dist[next] = Math.max(dist[next], Math.min(dist[cur.end], cost));
                queue.add(edges[cur.end].get(i));
            }
        }

        System.out.println(dist[e]);


    }

    
}
