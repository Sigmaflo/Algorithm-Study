import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    List<Node>[] list = new ArrayList[d + 1]; //도착지점까지
    for (int i = 0; i < d + 1; i++)
      list[i] = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      if (e <= d)
        list[e].add(new Node(s, w)); //도착하는 곳에 시작하는 곳과 길이 넣음
    }

    int[] dist = new int[d + 1];

    dist[0] = 0;
    for (int i = 1; i <= d; i++) {
      dist[i] = dist[i - 1] + 1; // 그냥 한 칸씩 이동
      
      if (list[i].size() != 0) //지름길 발견
        for (int j = 0; j < list[i].size(); j++)
          dist[i] = Math.min(dist[i], dist[list[i].get(j).no] + list[i].get(j).weight); //기존의 그 거리까지의 최소값과 지릅길 값 비교
    }

    System.out.print(dist[d]);
  }

  static class Node{
    int no, weight;

    public Node(int no, int weight) {
      this.no = no;
      this.weight = weight;
    }
  }
}
