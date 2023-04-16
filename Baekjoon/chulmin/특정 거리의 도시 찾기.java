import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, X;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int[] dist = new int[N+1];
		Arrays.fill(dist, -1);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(X);
		dist[X] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int child : list[cur]) {
				if(dist[child]==-1) {
					dist[child] = dist[cur] + 1;
					queue.add(child);
				}
			}
		}
		
		boolean check = false;
		for(int i=1; i<=N; i++) {
			if(dist[i]==K) {
				System.out.println(i);
				check = true;
			}
		}
		if(!check)
			System.out.println(-1);
	}
		
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		br.close();		
	}
}
