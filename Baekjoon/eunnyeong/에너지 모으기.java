import java.io.*;
import java.util.*;
import sun.lwawt.macosx.CSystemTray;

public class Main {

  static int[] a;
  static int n, ans = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    LinkedList<Integer> list = new LinkedList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      list.add(Integer.parseInt(st.nextToken()));

    calc(0, list);
    System.out.print(ans);
  }

  public static void calc(int sum, LinkedList<Integer> list) {
    if (list.size() == 2) {
      ans = Math.max(ans, sum);
      return;
    }

    for (int i = 1; i < list.size() - 1; i++) {
      int tmp = 0;
      tmp += list.get(i - 1);
      tmp += list.get(i + 1);
      LinkedList<Integer> x = (LinkedList<Integer>) list.clone();
      x.remove(i);
      calc(sum + tmp, x);
    }
  }
}
