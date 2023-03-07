import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타일리시 {
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

            if(p == 0 && q == 0) break;

            indents = new int[81][81][81];
            for(int i = 0; i <= 80; i++) {
                for(int j = 0; j <= 80; j++) {
                    Arrays.fill(indents[i][j], -1);
                }
            }

            for(int i = 0; i < p; i++) {
                String line = br.readLine();

                R += (int) (line.chars().filter(c -> c == '(').count() - line.chars().filter(c -> c == ')').count());
                C += (int) (line.chars().filter(c -> c == '{').count() - line.chars().filter(c -> c == '}').count());
                S += (int) (line.chars().filter(c -> c == '[').count() - line.chars().filter(c -> c == ']').count());
                indents[R][C][S] = line.length() - line.replaceFirst("^.*", "").length();
            }

            R = 0;
            C = 0;
            S = 0;
            for(int i = 0; i < q; i++) {
                String line = br.readLine();

                R += (int) (line.chars().filter(c -> c == '(').count() - line.chars().filter(c -> c == ')').count());
                C += (int) (line.chars().filter(c -> c == '{').count() - line.chars().filter(c -> c == '}').count());
                S += (int) (line.chars().filter(c -> c == '[').count() - line.chars().filter(c -> c == ']').count());

                answer.append(findIndent(R, C, S)).append(" ");
            }
            bw.write(answer.append("\n").toString());
        }

        br.close();
        bw.close();
    }

    private static int findIndent(final int R, final int C, final int S) {
        int answer = -1;
        if(indents[R][C][S] != -1) return answer;

        for(int r = 0; r < R / 2; r++) {
            for(int c = 0; c < C / 2; c++) {
                for(int s = 0; s < S / 2; s++) {
                    int result1 = findIndent(r, c, s);
                    int result2 = findIndent(R - r, C - c, S - s);
                    if(result1 == -1 || result2 == -1) continue;
                    if(answer == -1) answer = result1 + result2;
                    if(answer != result1 + result2) return -1;
                }
            }
        }
        return answer;
    }
}
