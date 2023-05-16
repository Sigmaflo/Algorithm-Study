import java.util.*;

public class Main {
	static final int MOD = 987654321;
    static long[] Hand = new long[10005];
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		
		Hand[0] = 1;
		Hand[2] = 1;
		
		for (int i = 4; i <= x; i+= 2) {
			for (int j = 0; j < i; j += 2) {
				Hand[i] += Hand[i - j - 2] * Hand[j];
                Hand[i] %= MOD;
			}
		}
		
		System.out.println(Hand[x]);
	}	
}
