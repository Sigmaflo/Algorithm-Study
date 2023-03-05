import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    String s = br.readLine();
    boolean[] visit = new boolean[n];
    char[] a = s.toCharArray();

    for (int i = 0; i < n; i++)
      if (a[i] == 'P')
        visit[i] = true;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 'P') {
        int f = 0;
        int x = i - k, y = i - 1;
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        for (int j = x; j <= y; j++) { //뒤 먼저 탐색
          if (a[j] == 'H' && !visit[j]) {
            cnt++;
            visit[j] = true;
            f = 1;
            break;
          }
        }
        if (f == 0) {
          x = i + 1; y = i + k;
          if (x >= n) x = n - 1;
          if (y >= n) y = n - 1;
          for (int j = x; j <= y; j++) { //뒤에 없으면 앞으로
            if (a[j] == 'H' && !visit[j]) {
              cnt++;
              visit[j] = true;
              break;
            }
          }
        }
      }
    }

    System.out.print(cnt);
  }
}
