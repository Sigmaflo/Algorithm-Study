import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    String s = br.readLine();
    HashMap<Integer, Character> h = new HashMap<>();
    int[] alpha = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      h.put(i, ch);
      alpha[ch - 'A']++;
    }

    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      s = br.readLine();
      char[] a = s.toCharArray();
      int[] tmp = new int[26];

      int cnt = 0, dif = 0;
      for (int j = 0; j < a.length; j++) {
        if (!h.containsValue(a[j]))
          cnt++;
        tmp[a[j] - 'A']++;
      }

      for (int j = 0; j < a.length; j++)
        if (alpha[a[j] - 'A'] != tmp[a[j] - 'A'])
          dif++;
      
      if (cnt <= 1 && dif <= 1 && Math.abs(a.length - h.size()) <= 1) {
        ans++;
        //System.out.println(s);
      }
    }

    System.out.print(ans);
  }
}
