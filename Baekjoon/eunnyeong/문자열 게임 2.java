import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < t; k++) {
      String s = br.readLine();
      int n = Integer.parseInt(br.readLine());

      int[] a = new int[26];
      int start = 0, end = 1, ll = 0, sl = Integer.MAX_VALUE;
      int idx = s.charAt(0) - 'a';
      a[idx]++;

      while (true){
        if (end < s.length() - 1) {
          idx = s.charAt(end) - 'a';
          a[idx]++;
          end++;
        }
        else {
          idx = s.charAt(start) - 'a';
          a[idx]--;
          start++;
        }

        if (a[idx] == n) {
          sl = Math.min(sl, end - start + 1);
          ll = Math.max(ll, end - start + 1);
        }
        if (start >= s.length() - 1  && end >= s.length() - 1)
          break;
      }
      if (ll == 0 && sl == Integer.MAX_VALUE)
        sb.append("-1\n");
      else
        sb.append(sl + " " + ll + "\n");
    }
    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
