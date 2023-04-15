import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> S = new HashSet<>();
        final List<Integer> array = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            array.add(i);
        }

        while (M-- > 0) {
            String[] op = br.readLine().split(" ");

            if (op.length == 1) {
                if (op[0].equals("all")) S.addAll(array);
                else if (op[0].equals("empty")) S.clear();
                continue;
            }

            Integer n = Integer.parseInt(op[1]);

            if (op[0].equals("add")) S.add(n);
            else if (op[0].equals("remove")) S.remove(n);
            else if (op[0].equals("check")) bw.write((S.contains(n)? 1 : 0) + "\n");
            else if (op[0].equals("toggle")) if (!S.add(n)) S.remove(n);
        }

        br.close();
        bw.close();
    }
}
