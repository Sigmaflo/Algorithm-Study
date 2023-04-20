import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> q = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        if (q.isEmpty())
          sb.append(0 + "\n");
        else sb.append(q.poll() + "\n");
      }
      else
        q.add(x);
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
