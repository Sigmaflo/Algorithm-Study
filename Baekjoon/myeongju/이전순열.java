import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] perm;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		perm = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}

		if (np(perm)) {

			for (int i = 0; i < perm.length; i++) {
				bw.write(Integer.toString(perm[i]));
				bw.write(' ');
			}
		}
		
		else {
			bw.write("-1");
		}
		
		bw.flush();
		bw.close();

	}

	private static boolean np(int[] perm) {

		int n = perm.length;

		int i = n - 1;
		while (i > 0 && perm[i - 1] <= perm[i]) --i;
		
		if (i == 0) return false;

		int j = n - 1;

		while (perm[i - 1] <= perm[j]) --j;

		swap(perm, i - 1, j);

		int k = n - 1;
		while (i < k) swap(perm, i++, k--);

		return true;
	}

	private static void swap(int[] perm, int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;

	}
}
