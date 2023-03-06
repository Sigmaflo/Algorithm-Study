import java.io.*;
import java.util.*;

public class LCS_2 {
    static int[] dx = { 0, -1, -1, 0 };
    static int[] dy = { 0, -1, 0, -1 };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()][s2.length()];
        int[][] direct = new int[s1.length()][s2.length()];

        boolean find = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)) {
                find = true;
                direct[i][0] = 1;
            }
            else {
                direct[i][0] = 2;
            }

            if(find) dp[i][0] = 1;
        }

        find = false;
        for(int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) == s1.charAt(0)) {
                find = true;
                direct[0][i] = 1;
            }
            else {
                direct[0][i] = 3;
            }

            if(find) dp[0][i] = 1;
        }

        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                if(dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                    direct[i][j] = 3;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                    direct[i][j] = 2;
                }

                if(s1.charAt(i) == s2.charAt(j)) {
                    if(dp[i][j] < dp[i - 1][j - 1] + 1) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        direct[i][j] = 1;
                    }
                }
            }
        }

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        System.out.println(dp[i][j]);
        List<Character> result = new ArrayList<>();

        while(i >= 0 && j >= 0 && dp[i][j] > 0) {
            int dir = direct[i][j];
            if(dir == 1) {
                result.add(s1.charAt(i));
            }

            i += dx[dir];
            j += dy[dir];
        }

        for(int k = result.size() - 1; k >= 0; k--) {
            bw.write(result.get(k));
        }
        bw.flush();
        bw.close();
    }
}
