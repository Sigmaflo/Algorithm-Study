import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();

    int size = s.length();
    int[] a = new int[size];
    int[] t = new int[size];
    for (int i = 0; i < size; i++) {
      a[i] = s.charAt(i) - '0';
      t[i] = s.charAt(i) - '0';
    }

    int idx = 0;
    for (int i = 1; i < size; i++) {
      if (a[i] <= a[i - 1]) {
        if (a[i] == idx && idx > 0) {
          t[i] = t[i - 1] + 1;
        }
        idx++;
        t[i] += idx * 10;
      }
      else {
        t[i] += idx * 10;
      }
    }

    for (int i = 0; i < size; i++)
      System.out.print(t[i] + " ");

  }
}
