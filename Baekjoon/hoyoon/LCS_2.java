import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string1 = br.readLine().split("");
        String[] string2 = br.readLine().split("");
        int[][] lcs = new int[string1.length + 1][string2.length + 1];

        for (int i = 1; i <= string1.length; i++) {
            for (int j = 1; j <= string2.length; j++) {
                if (string1[i - 1].equals(string2[j - 1])) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int i = string1.length;
        int j = string2.length;

        while (lcs[i][j] != 0) {
            if (lcs[i][j] == lcs[i - 1][j]) {
                i--;
            } else if (lcs[i][j] == lcs[i][j - 1]) {
                j--;
            } else {
                answer.insert(0, string1[i - 1]);
                i--;
                j--;
            }
        }

        System.out.println(lcs[string1.length][string2.length]);
        System.out.println(answer);
        br.close();
    }
}
