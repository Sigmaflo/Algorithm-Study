import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		list = new List[N+1];
		list[0] = new ArrayList<>();
		int res = 0;
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			char cmd = st.nextToken().charAt(0);
			if (cmd == 'a') {
				int k = Integer.valueOf(st.nextToken());
				list[i].addAll(list[i - 1]);
				list[i].add(k);
				res = list[i].get(list[i].size() - 1);
			} else if (cmd == 's') {
				List<Integer> tmp = list[i - 1];
				list[i].addAll(tmp);
				res = getLast(tmp, i, 's');
			} else {
				int k = Integer.valueOf(st.nextToken());
				List<Integer> tmp = list[k - 1];
				list[i].addAll(tmp);
				res = getLast(tmp, i, 't');
			}
			System.out.println(res);
		}
	}

	static int getLast(List<Integer> tmp, int i, char type) {
		int res = 0;
		if (type == 's')
			list[i].remove(tmp.size() - 1);
		if(list[i].size()==0)
			res = -1;
		else
			res = list[i].get(list[i].size() - 1);
		return res;
	}
}
