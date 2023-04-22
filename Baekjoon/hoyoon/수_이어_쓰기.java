import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수_이어_쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();

        int idx = 0;
        int i = 0;
        LOOP:
        while (true){
            String iAsString = String.valueOf(++i);
            for (int j = 0; j < iAsString.length(); j++) {
                if (iAsString.charAt(j) == numbers.charAt(idx)) {
                    idx++;
                    if (idx == numbers.length())
                        break LOOP;
                }
            }
        }

        System.out.println(i);
        br.close();
    }
}
