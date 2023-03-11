package Baekjoon.seungah;

import java.util.*;
import java.io.*;

public class 트리의지름 {
    static int N;
    static StringTokenizer st;
    static int p, c, w;
    static int ans, sum, fn;
    static boolean[] check;
    static ArrayList<node>[] nodes;

    static class node {
        int child;
        int weight;
        node(int child, int weight) {
            this.child = child;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        check = new boolean[N+1];
        ans = 0; sum = 0; fn = 0;

        for(int i=0;i<=N;i++) {
            nodes[i] = new ArrayList<node>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            p = Integer.parseInt(st.nextToken());
            while(true){
                c = Integer.parseInt(st.nextToken());
                if (c == -1) {
                    break;
                }
                w = Integer.parseInt(st.nextToken());
                nodes[p].add(new node(c, w));
            }
        }

        check[1] = true;
        DFS(1, 0);

        check = new boolean[N+1];
        ans = 0;
        check[fn] = true;
        DFS(fn, 0);

        System.out.println(ans);

    }
    private static void DFS(int start, int sum) {
        if(ans < sum) {
            ans = sum;
            fn = start;
        }

        for(node node : nodes[start]) {
            if(!check[node.child]) {
                check[node.child] = true;
                DFS(node.child, sum+node.weight);
            }
        }
    }
}
