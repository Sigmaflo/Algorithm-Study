import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거_분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] table = br.readLine().split("");
        boolean[] taken = new boolean[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            if(taken[i]) continue;
            for(int j = 1; j <= K && i + j < N; j++) {
                if(taken[i + j]) continue;
                if(!table[i].equals(table[i + j])) {
                    taken[i] = true;
                    taken[i + j] = true;
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
