import java.io.*;
import java.util.*;

public class Main {
  static int k;
  static int[] select;
  static char[] op;
  static String max = "0", min = "9999999999";
  static boolean[] visit;
    
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    k = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    op = new char[k];

    for (int i = 0; i < k; i++)
      op[i] = st.nextToken().charAt(0);

    select = new int[k + 1];
    visit = new boolean[10];

    perm(0);

    System.out.println(max);
    System.out.print(min);
  }

  public static void perm (int cnt) {
    if (cnt == k + 1) {
      for (int i = 0; i < k; i++)
        if (!check(select[i],op[i],select[i + 1]))
          return;
      String t = "";
      for (int i = 0; i < k + 1; i++)
        t += (char)(select[i] + '0');

      if (min.compareTo(t) > 0) min = t;
      if (max.compareTo(t) < 0) max = t;
      return;
    }

    for (int i = 0; i <= 9; i++) {
      if (!visit[i]) {
        visit[i] = true;
        select[cnt] = i;
        perm(cnt + 1);
        visit[i] = false;
      }
    }
  }

  public static boolean check(int x, char o, int y) {
    if (o == '<' && x < y)
      return true;

    if (o == '>' && x > y)
      return true;

    return false;
  }

}
