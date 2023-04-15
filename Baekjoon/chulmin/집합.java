import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		int num=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			int n;
			switch(cmd) {
			case "add":
				n = Integer.parseInt(st.nextToken());
				num |= (1<<n);
				break;
				
			case "remove":
				n = Integer.parseInt(st.nextToken());
				num &= ~(1<<n);
				break;
				
			case "check":
				n = Integer.parseInt(st.nextToken());
                sb.append((num & (1 << n)) != 0 ? "1\n" : "0\n");
				break;
				
			case "toggle":
				n = Integer.parseInt(st.nextToken());
				num ^= (1<<n);
				break;
				
			case "all" :
				num |= (~0);
				break;
			
			case "empty":
				num &= 0;
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}
}
