import java.io.*;
import java.util.*;

public class Main {
	static List<int[]> list;
	static int N, D, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		N=stoi(st.nextToken());
		D=stoi(st.nextToken());
		res = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int c = stoi(st.nextToken());
			list.add(new int[] {a, b, c});
		}
		Collections.sort(list, (o1, o2)->{
			return o1[0]-o2[0];
		});
		recur(0, 0, 0);
		System.out.println(res);
	}
	static void recur(int h, int end, int sum) {
		if(h == N) {
			if(end > D) {
				return;
			}else if(end==D){
				res = Math.min(res, sum);
			}else {
				res = Math.min(res, sum+D-end);
			}
			return;
		}
		int arr[] = list.get(h);
		if(arr[0] >= end) {
			recur(h+1, arr[1], sum+arr[2]+arr[0]-end);
		}
		recur(h+1, end, sum);
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
