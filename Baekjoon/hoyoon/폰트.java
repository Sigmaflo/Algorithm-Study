import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폰트 {
    private static final int FULL = 67108863;

    private static int[] sentences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sentences = new int[N];

        for (int i = 0; i < N; i++) {
            sentences[i] = stringToInt(br.readLine());
        }

        int answer = setOfContainsAllAlphabet(0, 0);

        System.out.println(answer);
        br.close();
    }

    private static int stringToInt(String s) {
        int result = 0;
        int[] indices = s.chars().map(i -> charToInt(i)).toArray();
        for (int i : indices) {
            result |= 1 << i;
        }
        return result;
    }

    private static int charToInt(int c) {
        return c - (int) 'a';
    }

    private static int setOfContainsAllAlphabet(int start, final int checkContains) {
        int result = 0;

        for (int i = start; i < sentences.length; i++) {
            int next = checkContains | sentences[i];
            if (next == FULL) result++;
            result += setOfContainsAllAlphabet(i + 1, next);
        }
        return result;
    }
}
