import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList list[] = new LinkedList[5];
		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();
			LinkedList<Integer> t = new LinkedList<>();
			for (int j = 0; j < 8; j++)
				t.add(s.charAt(j) - '0');
			list[i] = t;
		}
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int[] check = new int[5]; //톱니바퀴 체크
			check[x] = y;
			
			int c = y;
			for (int j = x + 1; j <= 4; j++) { //오른쪽 체크
				if (list[j].get(6) != list[j - 1].get(2)) {
					c *= -1;
					check[j] = c;
				}
				else break;
			}
			
			c = y;
			for (int j = x - 1; j >= 1; j--) { //왼쪽 체크
				if (list[j].get(2) != list[j + 1].get(6)) {
					c *= -1;
					check[j] = c;
				}
				else break;
			}

			for (int j = 1; j <= 4; j++) {
				if (check[j] == 1)
					list[j].addFirst(list[j].pollLast());
				if (check[j] == -1)
					list[j].addLast(list[j].pollFirst());
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 4; i++)
			if (list[i].get(0) == (Object)1)
				sum += 1 * Math.pow(2, i - 1);
		
		System.out.println(sum);	
	}
}
