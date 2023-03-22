import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 밑_줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        int dCnt = M - Arrays.stream(words).mapToInt(String::length).sum();
        int dCntForAll = dCnt / (N - 1);
        StringBuilder delimiter = new StringBuilder();
        while (dCntForAll-- > 0) delimiter.append("_");
        String answer = String.join(delimiter.toString(), words);

        for (int i = 1; i < N && answer.length() < M; i++) {
            if ('a' <= words[i].charAt(0) && words[i].charAt(0) <= 'z')
                answer = answer.replace(words[i], "_" + words[i]);
        }

        for (int i = N - 1; i > 0 && answer.length() < M; i--) {
            if ('A' <= words[i].charAt(0) && words[i].charAt(0) <= 'Z')
                answer = answer.replace(words[i], "_" + words[i]);
        }
        System.out.println(answer);
        br.close();
    }
}
