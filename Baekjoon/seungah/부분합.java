package Baekjoon.seungah;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class 부분합 {
    static int N;
    static int S;
    static int[] nums;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        S = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N+1];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        // 수열에서 연속된 부분합 중 그 합이 S 이상이 되는 것 중에 가장 짧은 것의 길이를 구하라
        /// 투포인터 문제 + 부분합 문제!

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        int len = 0;
        while (right <= N) {
            if (sum < S) {
                sum += nums[right];
                right++;
            }
            else if (sum >= S) {
                len = (right-1) - left +1;
                sum -= nums[left];
                left++;
                if (answer > len) answer = len;
            }
        }
        // S 이상인 부분합이 없으면 0을 출력
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    } 
}
