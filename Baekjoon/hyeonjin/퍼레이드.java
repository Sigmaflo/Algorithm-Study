import java.io.*;
import java.util.*;

public class 퍼레이드 {
    static int arr[][];
    static int V, E;
    static ArrayList<Integer>[] list;
    static boolean end = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V];
        arr = new int[V][V];

        for(int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i < V; i++) {
            dfs(i, i, 0);
        }

        if(end) System.out.println("YES");
        else System.out.println("NO");
    }


    static void dfs(int now, int num, int count) {
        if(end) return;

        if(count == E) {
            end = true;
            return;
        }

        for(Integer next: list[now]) {
            if(arr[now][next] == num || arr[next][now] == num) {
                continue;
            }
            arr[now][next] = arr[next][now] = num;
            dfs(next, num, count+1);
        }
    }
}
