package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10972 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		StringBuilder sb = new StringBuilder();
		if(check()) {
			for(int i : arr) {
				sb.append(i + " ");
			}
		}
		else
			sb.append(-1);
		System.out.println(sb);
	}
	
	private static boolean check() {
		// 규칙 1. 앞에가 뒤에 보다 작은 수 찾기
		int i = N-1;
		
		while(i>0 && arr[i-1] > arr[i])
			i--;
		// i가 0이라면 모든 배열이 내림차순이다.
		// 즉 배열 중에 가장 큰 수이다.
		if(i==0)
			return false;
			
		int j = N-1;
		
		// 규칙 2 arr[i-1]보다 큰 수 중에 가장 뒤에 있는 수(가장 작은 수)를 찾기
		while(arr[j] <= arr[i-1]) {
			j--;
		}
		swap(i-1, j);
		
		// 규칙 3. 내림차순으로 가장 큰 수이기 때문에 오른차순으로 가장 작은 수로 바꾸기
		j = N-1;
		while(i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	private static void swap(int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();		
	}
}
