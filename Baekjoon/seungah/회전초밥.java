package Baekjoon.seungah;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class 회전초밥 {
    static int N, D, K, C;
    static int[] sushi;
    static int[] ate;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken()); // 접시 수
        D = Integer.valueOf(st.nextToken()); // 초밥 가짓수
        K = Integer.valueOf(st.nextToken()); // 연속해서 먹는 접시 개수
        C = Integer.valueOf(st.nextToken()); // 쿠폰 번호

        sushi = new int[N];
        ate = new int[3001]; // 먹은 초밥 번호 (최대 3000개)

        for (int i=0; i<N; i++){
            sushi[i] = Integer.valueOf(br.readLine());
        }

        int cnt = 0;
        for (int i=0; i<K; i++){
            if (ate[sushi[i]] == 0){
                cnt++; // 처음 조합의 초밥 가짓수
            }
            ate[sushi[i]]++;
        }

        int max = cnt;
        // 1 ~ n-1까지 start를 이동시킴
        for(int i=0; i<N; i++){ ///////////////// 범위 중요
            if (max <= cnt) {
                if (ate[C] == 0) { // 쿠폰초밥 안먹은 경우
                    max = cnt + 1;
                }
                else { // 쿠폰초밥 먹은 경우
                    max = cnt;
                }
            }
            // start 이동 (빼줌)
            ate[sushi[i]]--; // 이전에 먹은 초밥 제거
            if (ate[sushi[i]] == 0) {
                cnt--;
            }

            // end 이동 (더해줌))
            int end = (i+K)%N;
            if(ate[sushi[end]] == 0) {
                cnt++;
            }
            ate[sushi[end]]++;
        }

        System.out.println(max);
    }
}