package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			sb.append(check(line, 0, line.length()-1, 0)+"\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int check(String line, int s, int e, int cnt) {
		if(cnt == 2)
			return 2;
		
		while(s <= e) {
			if(line.charAt(s) == line.charAt(e)) {
				s++;
				e--;
			}
			else {
				return Math.min(check(line, s+1, e, cnt+1), check(line, s, e-1, cnt+1));
			}
		}
		return cnt;
	}
}
