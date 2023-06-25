import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      q.add(x);
    }

    Stack<Integer> s = new Stack<>();
    int ans = 0;
    while (!q.isEmpty()) {
      int x = q.poll();
      int cnt = 0;
      while (true) {
        if (!s.isEmpty() && s.peek() < x) {
          s.pop();
          cnt++;
        }
        else
          break;
      }
      ans += s.size() - cnt;
      s.push(x);
    }

    System.out.print(ans);
  }
}
