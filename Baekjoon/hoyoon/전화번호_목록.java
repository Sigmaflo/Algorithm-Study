import java.io.*;
import java.util.TreeSet;

public class 전화번호_목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            TreeSet<String> set = new TreeSet<>();
            int n = Integer.parseInt(br.readLine());
            String result = "YES";

            while (n-- > 0) {
                set.add(br.readLine());
            }

            String[] numbers = set.toArray(String[]::new);

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1].startsWith(numbers[i])) {
                    result = "NO";
                    break;
                }
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
