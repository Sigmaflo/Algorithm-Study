import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String s = br.readLine();

    String t = "IO";
    String x = "";
    for (int i = 0; i < n; i++)
      x += t;
    x += "I";

    int size = x.length(), cnt = 0;
    for (int i = 0; i < s.length() - size + 1; i++)
      if (s.charAt(i) == 'I' && s.substring(i, i + size).equals(x))
        cnt++;

    System.out.print(cnt);
  }
}
