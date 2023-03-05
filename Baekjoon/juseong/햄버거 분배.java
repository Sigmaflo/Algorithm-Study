import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans;

    public static void main(String[] args) throws IOException {
        // 사람람과 햄버거를 찾는다
        // 왼쪽의 햄버거 부터 사람과 매칭한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 'P') continue;
            for (int j = i - k; j <= i + k; j++) {
                if (j >= 0 && j < n && input[j] == 'H') {
                    ans++;
                    input[j] = 'e';
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
