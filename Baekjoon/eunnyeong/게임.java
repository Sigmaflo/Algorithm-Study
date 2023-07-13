import java.io.*;
import java.util.*;

public class Main {

  static long x, y, z, ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    z = y / x * 100;

    long s = 1, e = (long)(x * 0.1);
    
    System.out.println(bin(s, e));
  }

  public static long bin(long s, long e) {
    while(s <= e) {
      long mid = (s + e) / 2;
      long t = ((y + mid) * 100) / (x + mid);
      if (t > z)
        e = mid - 1;
      else if (t == z)
        s = mid + 1;
    }
    return s;
  }
}
