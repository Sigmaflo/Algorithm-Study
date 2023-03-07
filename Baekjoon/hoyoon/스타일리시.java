import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타일리시 {
    private static final int MAX = 40;

    private static int[][][] indents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int R = 0;
            int C = 0;
            int S = 0;
            StringBuilder answer = new StringBuilder();

            if (p == 0 && q == 0) break;

            indents = new int[MAX + 1][MAX + 1][MAX + 1];
            for (int i = 0; i <= MAX; i++) {
                for (int j = 0; j <= MAX; j++) {
                    Arrays.fill(indents[i][j], -1);
                }
            }

            String line = "";
            for (int i = 0; i < p; i++) {
                line = br.readLine();
                indents[R][C][S] = line.length() - line.replaceFirst("^\\.*", "").length();

                for (int j = 2; j <= R; j++) {
                    if (R % j == 0 && C % j == 0 && S % j == 0) {
                        indents[R / j][C / j][S / j] = indents[R][C][S] / j;
                    }
                }

                R += (int) (line.chars().filter(c -> c == '(').count() - line.chars().filter(c -> c == ')').count());
                C += (int) (line.chars().filter(c -> c == '{').count() - line.chars().filter(c -> c == '}').count());
                S += (int) (line.chars().filter(c -> c == '[').count() - line.chars().filter(c -> c == ']').count());
            }

            correctIndents();

            R = 0;
            C = 0;
            S = 0;
            for (int i = 0; i < q; i++) {
                line = br.readLine();
                answer.append(findIndent(R, C, S)).append(" ");

                R += (int) (line.chars().filter(c -> c == '(').count() - line.chars().filter(c -> c == ')').count());
                C += (int) (line.chars().filter(c -> c == '{').count() - line.chars().filter(c -> c == '}').count());
                S += (int) (line.chars().filter(c -> c == '[').count() - line.chars().filter(c -> c == ']').count());
            }
            bw.write(answer.append("\n").toString());
        }

        br.close();
        bw.close();
    }

    private static void correctIndents() {
        if (indents[1][1][0] != -1 && indents[1][1][0] % 2 == 0
                && indents[1][0][0] == -1 && indents[0][1][0] == -1) {
            indents[1][0][0] = indents[1][1][0] / 2;
            indents[0][1][0] = indents[1][1][0] / 2;
        }
        if (indents[0][1][1] != -1 && indents[0][1][1] % 2 == 0
                && indents[0][1][0] == -1 && indents[0][0][1] == -1) {
            indents[0][1][0] = indents[0][1][1] / 2;
            indents[0][0][1] = indents[0][1][1] / 2;
        }
        if(indents[1][1][1] != -1 && indents[1][1][1] % 3 == 0
            && indents[1][0][0] == -1 && indents[0][1][0] == -1 && indents[0][0][1] == -1) {
            indents[1][0][0] = indents[1][1][1] / 3;
            indents[0][1][0] = indents[1][1][1] / 2;
            indents[0][0][1] = indents[1][1][1] / 2;
        }
    }

    private static int findIndent(final int R, final int C, final int S) {
        int answer = -1;
        if (indents[R][C][S] != -1) return indents[R][C][S];

        for (int r = 0; r <= R; r++) {
            for (int c = 0; c <= C; c++) {
                for (int s = 0; s <= S; s++) {
                    if ((r == 0 && c == 0 && s == 0) || (r == R && c == C && s == S)) continue;
                    int result1, result2;
                    if ((result1 = findIndent(r, c, s)) == -1) continue;
                    if ((result2 = findIndent(R - r, C - c, S - s)) == -1) continue;
                    if (answer == -1) answer = result1 + result2;
                    else if(answer != result1 + result2) return -1;
                }
            }
        }
        if(answer != -1) indents[R][C][S] = answer;
        return answer;
    }
}
