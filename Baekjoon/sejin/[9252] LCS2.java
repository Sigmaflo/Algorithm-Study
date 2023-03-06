import java.io.*;
import java.util.*;

public class Main{

	static int[] arrA , arrB;
	static int[][] dp ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputA = br.readLine();
		int A_Length = inputA.length();

		String inputB = br.readLine();
		int B_Length = inputB.length();
		dp = new int[A_Length+1][B_Length+1];

		StringBuilder sb = new StringBuilder();

		// 겹치는 부분 구하기
		for(int i=1;i<A_Length+1;i++){
			for(int j=1;j<B_Length+1;j++){
				if(inputA.charAt(i-1) == inputB.charAt(j-1)){
					// 값이 같을 때 (dp[i-1][j-1]) 인데 i-1만 적용함
					dp[i][j] = Math.max(dp[i-1][j-1] + 1 , dp[i][j-1]);
				}else {
					// 다를 때 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		System.out.println(dp[A_Length][B_Length]);
		// System.out.println(Arrays.deepToString(dp));

		if(dp[A_Length][B_Length] == 0 ) System.exit(0);

		int maxNum = dp[A_Length][B_Length] ;
		for(int i=A_Length;i>0;i--){
			for(int j=B_Length;j>0;j--){
				if(dp[i][j] == maxNum && (inputA.charAt(i-1) == inputB.charAt(j-1))){
					sb.append(inputA.charAt(i-1));
					maxNum -- ;
					break;
				}
			}
		}

		sb.reverse();
		System.out.println(sb.toString());
    }
}
