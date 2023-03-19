import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int num = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < num; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      PriorityQueue<Integer> a = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2 - o1;
        }
      });
      PriorityQueue<Integer> b = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2 - o1;
        }
      });

      st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens())
        a.add(Integer.parseInt(st.nextToken()));

      st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens())
        b.add(Integer.parseInt(st.nextToken()));

      int cnt = 0;
      while (!a.isEmpty()) {
        int x = a.poll();
        PriorityQueue<Integer> q = b;
        while (!q.isEmpty()) {
          if (x > q.peek()) {
            cnt += q.size();
            break;
          }
          q.poll();
        }
      }
      sb.append(cnt + "\n");
    }
    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
