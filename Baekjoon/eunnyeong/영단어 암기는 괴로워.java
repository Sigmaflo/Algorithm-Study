import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    String[] a = new String[n];
    Arrays.fill(a, "");

    int idx = 0;
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (s.length() < m) continue;
      a[idx++] = s;
    }

    Arrays.sort(a, 0, idx);

    PriorityQueue<Word> q = new PriorityQueue<>();
    int cnt = 0;
    String t = a[0];
    for (int i = 0; i < idx; i++) {
      if (!t.equals(a[i])) {
        q.add(new Word(t, t.length(), cnt));
        t = a[i];
        cnt = 1;
      }
      else
        cnt++;

      if (i == n - 1)
        q.add(new Word(t, t.length(), cnt));
    }

    StringBuilder sb = new StringBuilder();
    while(!q.isEmpty())
      sb.append(q.poll().s + "\n");
    bw.write(sb.toString());
    bw.close(); br.close();
  }

  static class Word implements Comparable<Word>{
    String s;
    int len, cnt;

    public Word(String s, int len, int cnt) {
      this.s = s;
      this.len = len;
      this.cnt = cnt;
    }

    @Override
    public int compareTo(Word o) {
      if (this.cnt == o.cnt) {
        if (this.len == o.len) {
          return this.s.compareTo(o.s);
        }
        return o.len - this.len;
      }
      return o.cnt - this.cnt;
    }
  }
}
