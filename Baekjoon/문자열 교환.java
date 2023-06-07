import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int size = s.length(), cnt = 0, bCnt = 0;
    for (int i = 0; i < size; i++) {
      if (s.charAt(i) == 'a')
        cnt++;
      else bCnt++;
    }

    int num = 0, numA = 0;
    for (int i = 0; i < cnt; i++) {
      if (s.charAt(i) == 'b')
        num++;
      else numA++;
    }

    if (bCnt <= 1 || numA == cnt) {
      System.out.print(0);
      System.exit(0);
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 1; i < size; i++) {
      if (s.charAt(i - 1) == 'b') num--;

      int idx = i + cnt - 1;
      if (idx >= size) idx %= size;
      if (s.charAt(idx) == 'b') num++;

      ans = Math.min(ans, num);
    }

    if (ans == Integer.MAX_VALUE)
      ans = 0;

    System.out.print(ans);
  }
}
