import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		dijkstra();
		System.out.println(dist[K]);
	}
	
	private static void dijkstra() {
		dist = new int[100_001];
		Arrays.fill(dist, 100_000);
		dist[N] = 0;
		
		PriorityQueue<Node13549> pq = new PriorityQueue<>();
		
		pq.add(new Node13549(N, 0));
		
		while(!pq.isEmpty()) {
			Node13549 cur = pq.poll();
			
			if(dist[cur.idx] < cur.dist)
				continue;
			
			if(cur.idx - 1 >= 0 && dist[cur.idx-1] > cur.dist + 1) {
				dist[cur.idx - 1] = cur.dist + 1;
				pq.add(new Node13549(cur.idx-1, cur.dist + 1));
			}
			
			if(cur.idx + 1 <= 100_000 && dist[cur.idx + 1] > cur.dist + 1) {
				dist[cur.idx + 1] = cur.dist + 1;
				pq.add(new Node13549(cur.idx+1, cur.dist + 1));
			}
			
			if(cur.idx * 2 <= 100_000 && dist[cur.idx * 2] > cur.dist) {
				dist[cur.idx * 2] = cur.dist;
				pq.add(new Node13549(cur.idx*2, cur.dist));
			}
		}
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();
	}
}
class Node13549 implements Comparable<Node13549> {
	int idx;
	int dist;
	
	public Node13549(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Node13549 o) {
		return this.dist - o.dist;
	}
}
